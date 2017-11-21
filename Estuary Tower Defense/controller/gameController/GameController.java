package gameController;

import gameView.GameView;
import main.GameModel;

public class GameController {
	public static GameModel model;
	public static GameView view;
	static boolean isRoundActive;

	public GameController() {
		model = new GameModel();
		modelInit();
		view = new GameView();
		boardMenuInit();
		view.boardMenu.setVisible(false);
		view.mainMenu.setVisible(true);
		view.leaderBoard.setVisible(false);
	}

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
	
	public static void endRound() {
		// model.resetScorePanel(); // resets the scorePanel in the game
		System.out.println("Game over man!");
	}

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
	
	public static void showBoardMenu() {
		view.boardMenu.setVisible(true);
		view.mainMenu.setVisible(false);
	}

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

	// Sees if the player is dead, returns true if he is
	public static boolean checkPlayerIsDead() {
		return model.isPlayerDead();
	}

	public static void setIsRoundActive(boolean updateIsRoundActive) {
		isRoundActive = updateIsRoundActive;
	}

	public static boolean isRoundActive() {
		return isRoundActive;
	}
}
