package BoardMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import MainMenu.TitlePanel;

public class BoardMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final int ADJUST_SIDE = 20; // adjust the bottom of the screen
	final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH_OF_SCREEN = SCREEN_SIZE.width; // sets the width of screen from getPreferredSize method
	final int HEIGHT_OF_SCREEN = SCREEN_SIZE.height-ADJUST_SIDE; // set the height of screen from getPreferredSize method
	
	TitlePanel title = new TitlePanel("Welcome to Estuary Tower Defense");
	
	BoardSideGamePanel sidePanel = new BoardSideGamePanel();
	BoardButtonPanel buttonPanel = new BoardButtonPanel();

	// Constructor for TowerDefenseView Class
	public BoardMenuView() {
		initGUI(); // calls the method to setup the rest of the screen
		setMainScreen(); // creates the base of the game board
	}

	// private method to set graphical interface up
	private void initGUI() {

		// places the title across the screen
		add(title, BorderLayout.PAGE_START);

		// add the side panel to the game
		add(sidePanel, BorderLayout.EAST);

		// adds the button panel to the bottom of the screen
		add(buttonPanel, BorderLayout.PAGE_END);
		
		// adds the center panel to the screen
	}

	// sets up the main base panel for the game
	private void setMainScreen() {
		setTitle("Estuary Tower Defense"); // sets the title of the screen
		setSize(WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN); // sets the size of the screen
		setLocationRelativeTo(null); // centers the screen on the display
		setResizable(false); // disables the ability to make the screen bigger or smaller
		setVisible(true); // makes the screen visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes the screen if the user exits from window
	}

	// gets the preferred size of the screen that we want to use
	public Dimension getPreferredSize() {
		Dimension size = new Dimension((int) SCREEN_SIZE.getWidth(), 
				(int) SCREEN_SIZE.getHeight());
		return size;
	}
}