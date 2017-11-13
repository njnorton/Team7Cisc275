package gameView;
import boardMenuView.BoardMenuView;
import mainMenuView.MainMenuView;

/**
 * Creates the gameview to create instances of the MainMenuView and BoardMenuView.
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

public class GameView {
	public MainMenuView mainMenu;
	public BoardMenuView boardMenu;
	
	public GameView() {
		mainMenu = new MainMenuView();
		boardMenu = new BoardMenuView();
	}
}
