package gameView;

import boardMenuView.BoardMenuView;
import leaderBoardView.LeaderBoardView;
import mainMenuView.MainMenuView;

/**
 * Creates the gameview to create instances of the MainMenuView, BoardMenuView
 * and leadershipViews .
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * MainMenuView mainMenu: an instance of the main menu view
 * BoardMenuView boardMenu: an instance of the board menu view
 * LeaderBoardView leaderBoard: an instance of the leader board view 
 */

public class GameView {
	public MainMenuView mainMenu;
	public BoardMenuView boardMenu;
	public LeaderBoardView leaderBoard;
	
	/**
	 * Sets up the instances for the main menu, board menu, and leadership views. 
	 */
	public GameView() {
		mainMenu = new MainMenuView();
		boardMenu = new BoardMenuView();
		leaderBoard = new LeaderBoardView();
	}
}
