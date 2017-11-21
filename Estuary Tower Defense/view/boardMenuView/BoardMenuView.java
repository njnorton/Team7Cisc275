package boardMenuView;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import mainMenuView.MainMenuTitlePanel;

/**
 * Sets up the overall board menu that displays everything to interact with the game. Will
 * place the proper panels in the right spot so that it sets up correctly in the different 
 * locations.
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * Dimension SCREEN_SIZE: the total size of the screen the game is being run on 
 * int WIDTH_OF_SCREEN: the total width of the final board menu screen of the game
 * int HEIGHT_OF_SCREEN: the total height of the final board menu screen of the game
 * MainMenuTitlePanel title: an accessor to the title panel of the game
 * BoardMenuCenterPanel centerPanel: an accessor to the center panel of the game
 * BoardMenuButtonPanel buttonPanel: an accessor to the button panel of the game 
 */

public class BoardMenuView extends JFrame {

	private static final long serialVersionUID = 1L;
	
	final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH_OF_SCREEN = SCREEN_SIZE.width*6/7; // sets the width of screen from getPreferredSize method
	final int HEIGHT_OF_SCREEN = SCREEN_SIZE.height*6/7; // set the height of screen from getPreferredSize method
	
	private MainMenuTitlePanel title;
	public BoardMenuCenterPanel centerPanel;
	public BoardMenuSideGamePanel sidePanel;
	public BoardMenuButtonPanel buttonPanel;
	
	
	/**
	 * Constructor that sets up and creates instances of the classes needed to make 
	 * the board menu view. Will also print out the screen size for reference to
	 * make sure that the entire game view will fit into the window. 
	 */
	public BoardMenuView() {
		title = new MainMenuTitlePanel("Welcome to Estuary Tower Defense");
		centerPanel = new BoardMenuCenterPanel();
		sidePanel = new BoardMenuSideGamePanel();
		buttonPanel = new BoardMenuButtonPanel();
		initGUI(); // calls the method to setup the rest of the screen
		setMainScreen(); // creates the base of the game board
		System.out.println(WIDTH_OF_SCREEN + " " + HEIGHT_OF_SCREEN);
	}

	/**
	 * Sets up all of the panels so they are placed in the correct spot in the JFrame 
	 * on the screen. There are a total of 4 panels that are placed in their respective 
	 * locations on the screen. 
	 */
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

	/**
	 * Makes the entire frame that the components of the board menu view will sit on. Sets 
	 * up all of the properties needed to make the view work correctly when it loads and is 
	 * exited.
	 */
	private void setMainScreen() {
		setTitle("Estuary Tower Defense"); // sets the title of the screen
		setSize(WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN); // sets the size of the screen
		setResizable(false); // disables the ability to make the screen bigger or smaller
		setLocationRelativeTo(null); // centers the screen on the display
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes the screen if the user exits from window
	}
}
