package BoardMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import MainMenu.TitlePanel;

public class BoardMenuView extends JFrame {

	private static final long serialVersionUID = 1L;

	final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH_OF_SCREEN = SCREEN_SIZE.width; // sets the width of screen from getPreferredSize method
	final int HEIGHT_OF_SCREEN = SCREEN_SIZE.height; // set the height of screen from getPreferredSize method
	final int GAP_SIZE_WIDTH = 20; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons

	TitlePanel title = new TitlePanel("Welcome to Estuary Tower Defense");
	JPanel buttonPanel = new JPanel();
	BoardSideGamePanel sidePanel = new BoardSideGamePanel();

	JButton exitButton = new JButton("Return to Main Menu");

	Dimension buttonSize = exitButton.getPreferredSize(); // sets the preferred size of buttons

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
		buttonPanel = buttonPanel();
		add(buttonPanel, BorderLayout.PAGE_END);
		
		// adds the center panel to the screen
	}

	private JPanel buttonPanel() {
		JPanel buttons = new JPanel();
		buttons.setLayout(new GridLayout(1, 2));
		buttons.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int) (buttonSize.getHeight()) + GAP_SIZE_HEIGHT));
		buttons.setBackground(Color.CYAN);
		buttons.add(exitButton);
		buttonPanel.add(buttons);

		return buttonPanel;
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
		Dimension size = new Dimension((int) SCREEN_SIZE.getWidth(), (int) SCREEN_SIZE.getHeight());
		return size;
	}
}
