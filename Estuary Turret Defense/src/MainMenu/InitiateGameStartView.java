package MainMenu;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import BoardMenu.BoardMenuView;

public class InitiateGameStartView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final static int SCREEN_WIDTH = 750; // sets up the sizing of the screen for width
	final static int SCREEN_HEIGHT = 500; // sets up the sizing of the screen for height

	// Constructor to initialize the graphical interface screens
	public InitiateGameStartView() {
		initGUI(); // makes GUI screen

		setMainGraphicsUp(); // creates the main panel for viewing 
	}

	// private method to make the different panels on the main panel
	private void initGUI() {

		// creates the Title Panel that goes across the top of the screen
		TitlePanel titlePanel = new TitlePanel("Estuary Tower Defense");
		add(titlePanel, BorderLayout.PAGE_START);
		
		// creates the center screen with the buttons attached
		StartGamePanel gamePanel = new StartGamePanel();
		add(gamePanel, BorderLayout.CENTER);
		
	}

	// sets the preferred size for the screen
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		return size;
	}
	
	// set the overall background panel that everything sits on
	private void setMainGraphicsUp(){
		setTitle("Main Menu"); // sets the title of the screen
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // sets the size of the screen
		setLocationRelativeTo(null); // sets in the middle of the screen
		setResizable(false); // unable to resize
		setVisible(true); // makes the GUI visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes on operation
	}

	public static void main(String[] args) {
		InitiateGameStartView m1 = new InitiateGameStartView(); // starts the game up to main menu
	}
}
