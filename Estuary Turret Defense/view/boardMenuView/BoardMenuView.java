package boardMenuView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import mainMenuView.TitlePanel;

public class BoardMenuView extends JFrame {

	private static final long serialVersionUID = 1L;

	final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH_OF_SCREEN = SCREEN_SIZE.width*6/7; // sets the width of screen from getPreferredSize method
	final int HEIGHT_OF_SCREEN = SCREEN_SIZE.height*6/7; // set the height of screen from getPreferredSize method
		
	TitlePanel title = new TitlePanel("Welcome to Estuary Tower Defense");
	
	BoardMenuCenterPanel centerPanel = new  BoardMenuCenterPanel();
	BoardMenuSideGamePanel sidePanel = new BoardMenuSideGamePanel();
	BoardMenuButtonPanel buttonPanel = new BoardMenuButtonPanel();
	
	// Constructor for TowerDefenseView Class
	public BoardMenuView() {
		initGUI(); // calls the method to setup the rest of the screen
		setMainScreen(); // creates the base of the game board
		System.out.println(WIDTH_OF_SCREEN + " " + HEIGHT_OF_SCREEN);
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
		add(centerPanel, BorderLayout.CENTER);
	}

	// sets up the main base panel for the game
	private void setMainScreen() {
		setTitle("Estuary Tower Defense"); // sets the title of the screen
		setSize(WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN); // sets the size of the screen
		setResizable(false); // disables the ability to make the screen bigger or smaller
		setLocationRelativeTo(null); // centers the screen on the display
		setVisible(true); // makes the screen visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes the screen if the user exits from window
	}
}
