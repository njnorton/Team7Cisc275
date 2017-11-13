package mainMenuView;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Sets up the overall main menu with all components that make up the view. 
 * 
 * @author  Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * int SCREEN_WIDTH: the width of the screen for the JFrame
 * int SCREEN_HEIGHT: the height of the screen for the JFrame 
 * 
 */

public class MainMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final static int SCREEN_WIDTH = 750; // sets up the sizing of the screen for width
	final static int SCREEN_HEIGHT = 500; // sets up the sizing of the screen for height
	
	
	/**
	 * Constructor that takes care of the entire setup of the main menu view. Calls 
	 * two different methods to do this for the main menu.
	 * 
	 */
	public MainMenuView() {
		initGUI(); // makes GUI screen

		setMainGraphicsUp(); // creates the main panel for viewing 
	}

	/**
	 * Sets up all panels to create the JFrame for the main menu. It contains the 
	 * MainMenuTitlePanel, MainMenuImagePanel and the MainMenuButtonPanel and adds 
	 * them in their respective locations on the JFrame. 
	 */
	private void initGUI() {

		// creates the Title Panel that goes across the top of the screen
		MainMenuTitlePanel titlePanel = new MainMenuTitlePanel("Estuary Tower Defense");
		add(titlePanel, BorderLayout.PAGE_START);
		
		// creates the center panel with a picture of an estuary 
		MainMenuImagePanel imagePanel = new MainMenuImagePanel();
		add(imagePanel, BorderLayout.CENTER);
		
		// creates the lower screen with the buttons attached
		MainMenuButtonPanel gamePanel = new MainMenuButtonPanel();
		add(gamePanel, BorderLayout.PAGE_END);
	}
	
	/**
	 * Returns back the preferred size of the JComponent. Sets the preferred size of the 
	 * JPanel to fit onto the JFrame of the main menu.
	 * 
	 * @return the preferred size of the JComponent 
	 */
	public Dimension getPreferredSize() {
		Dimension size = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
		return size;
	}
	
	/**
	 * Creates the JFrame characteristics needed to display the main menu and 
	 * what happens when the user terminates the program. 
	 */
	private void setMainGraphicsUp(){
		setTitle("Main Menu"); // sets the title of the screen
		setSize(SCREEN_WIDTH, SCREEN_HEIGHT); // sets the size of the screen
		setLocationRelativeTo(null); // sets in the middle of the screen
		setResizable(false); // unable to resize
		setVisible(true); // makes the GUI visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes on operation
	}
}
