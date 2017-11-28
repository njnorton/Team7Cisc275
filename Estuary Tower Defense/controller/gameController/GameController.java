package gameController;

import gameView.GameView;
import main.GameModel;

/**
 * Controls the game play with updates from the model that are passed along to the view. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * GameModel model: an instance of the GameModel
 * GameView view: an instance of the GameView that sets up the 3 views in the game
 * boolean isRoundActive: tells if the current round is active in the game 
 */

public class GameController {
	public static GameModel model;
	public static GameView view;
	static boolean isRoundActive;

	/**
	 * Constructor that sets up everything that is needed to run the game. Creates an 
	 * instance of the model and the views. Also makes the main menu visible to the user 
	 * and hides relevant views that are not needed. 
	 */
	public GameController() {
		model = new GameModel();
		modelInit();
		view = new GameView();
		boardMenuInit();
		view.boardMenu.setVisible(false);
		view.mainMenu.setVisible(true);
		view.leaderBoard.setVisible(false);
	}

	/**
	 * Initializes the model with the path assignments and sets up the player model with 
	 * health, money, score, and round times for each round and uses this information until
	 * the end of the game.
	 */
	public static void modelInit() {
		model.player.setHealth(30);
		model.player.setMoney(1000);
		model.player.setScore(0);
		model.player.setRoundTime(45);
		model.player.setTimeLeft(45);

		// Do path assignment here
		int[] xpath = new int[1000];
		int[] ypath = new int[1000];
		for (int i = 0; i < 1000; i++) {
			xpath[i] = i;
		}
		for (int i = 0; i < 1000; i++) {
			ypath[i] = i;
		}

		model.path.setxCorArr(xpath);
		model.path.setyCorArr(ypath);
		model.path.setSize(1000);

	}

	/**
	 * Updates the view with the player model information given from the previous method
	 * above. This information will be displayed when the user is in the boardMenuView JFrame
	 * after clicking on the start button from the main menu.
	 */
	public static void boardMenuInit() {
		view.boardMenu.sidePanel.scorePanel.setScore(model.player.getScore());
		view.boardMenu.sidePanel.scorePanel.setHealth(model.player.getHealth());
		view.boardMenu.sidePanel.scorePanel.setSandDollars(model.player.getMoney());
		view.boardMenu.sidePanel.timerPanel.setTime(model.player.getRoundTime());
	}

	// tested this method because we weren't sure on if timer was implemented in
	// true MVC fashion
	// can delete if it is
	public static void timeTick() {
		while (model.player.getTimeLeft() > 0) {
			model.player.setTimeLeft(model.player.getTimeLeft() - 1);
			view.boardMenu.sidePanel.timerPanel.setTime(model.player.getTimeLeft());

		}
		isRoundActive = false;
		model.player.setTimeLeft(model.player.getRoundTime());
	}
	
	/**
	 * The sequence of events that take place when the round is over after the time 
	 * is up in a particular round. 
	 */
	public static void endRound() {
		// model.resetScorePanel(); // resets the scorePanel in the game
		System.out.println("Game over man!");
	}

	/**
	 * Resolves the actions that the towers are able to make relative to the location of 
	 * the enemies on the screen. If the tower is in the range to shoot an enemy, then it 
	 * shoots the enemy causing it to lose health and the score to be updated when it hits an
	 * enemy. 
	 */
	public static void resolveTowerActions() {
		// Iterates through every turret
		for (int i = 0; i < model.towerList.size(); i++) {
			// Sees if the turret is allowed to shoot this round
			if (model.isReloading(i)) {
				// Iterates through every enemy
				for (int j = 0; j < model.enemyList.size(); j++) {
					// Checks if that given enemy is in range
					// This may be different for different turrets if they range
					// find differently
					if (model.isInRange(i, j)) {
						// Reset the reload count
						model.resetReload(i);
						// Damages the enemy, if he dies it'll return true
						model.damageEnemy(i, j);
						// Gives the player money for defeating the baddie
						model.gainBounty(j);
					}
					break;
				}
			}
		}
	}

	/**
	 * Resolves the actions of the enemies that are currently on the board. If the enemy 
	 * goes off of the game board, then a player will lose health and removes the enemy 
	 * from the arrayList of enemies.
	 */
	// Moves the enemy, if the enemy has successfully gotten out of bounds
	// the player loses life
	public static void resolveEnemyActions() {
		for (int i = 0; i < model.enemyList.size(); i++) {
			if (model.isOutOfBounds(i)) {
				model.enemyList.remove(i);
				model.reducePlayerHealth(1);
			}
		}
	}
	
	/**
	 * Shows the boardMenu JFrame and hides the mainMenu JFrame for the game.
	 */
	public static void showBoardMenu() {
		view.boardMenu.setVisible(true);
		view.mainMenu.setVisible(false);
	}

	/**
	 * Shows the mainMenu JFrame and hides the boardMenu JFrame for the game. 
	 */
	public static void showMainMenu() {
		view.boardMenu.setVisible(false);
		view.mainMenu.setVisible(true);
	}
	
	/**
	 * Shows the leaderboard with the list of high scores. This makes the JFrame
	 * visible for the user to view this information. 
	 */
	public static void showLeaderBoard(){
		view.leaderBoard.setVisible(true);
	}

	/**
	 * Checks to see if the current player is dead by running out of health. 
	 * Returns a true or false value depending on the state of the player. 
	 */
	// Sees if the player is dead, returns true if he is
	public static boolean checkPlayerIsDead() {
		return model.isPlayerDead();
	}
	
	/**
	 * Sets the current round to either active or not active based upon the value 
	 * that is given for the input. Allows the round to continue while the round is 
	 * active.
	 * 
	 * @param updateIsRoundActive true/false value that sets the round to active or inactive
	 */
	public static void setIsRoundActive(boolean updateIsRoundActive) {
		isRoundActive = updateIsRoundActive;
	}

	/**
	 * Checks to see if the current round is active and will return a true or 
	 * false value depending on this check.
	 * 
	 * @return is the current round active with a boolean true/false value.
	 */
	public static boolean isRoundActive() {
		return isRoundActive;
	}
}
