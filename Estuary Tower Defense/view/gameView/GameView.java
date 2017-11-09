package gameView;
import boardMenuView.BoardMenuView;
import mainMenuView.MainMenuView;

public class GameView {
	public MainMenuView mainMenu;
	public BoardMenuView boardMenu;
	
	public GameView() {
		mainMenu = new MainMenuView();
		boardMenu = new BoardMenuView();
	}
}
