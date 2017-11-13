package mainMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gameController.GameController;

/**
 * The button panel that is located on the bottom of the main menu to control how the game 
 * is played. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * int GAP_SIZE_WIDTH: an integer that represents the width of the buttons created
 * int GAP_SIZE_HEIGHT: an integer that represents the height of the buttons created
 * JPanel buttonPanel: the base panel that all components will lay on 
 * GridLayout buttonLayout: the layout that will be used to create a grid on the base panel
 * JButton startButton: the button that starts the board menu board to start game play 
 * JButton quitButton: the button that exits the game when clicked 
 * JButton tutorialButton: the button that will start the tutorial of the game 
 * Dimension buttonSize: sets the preferred size of the buttons that are created 
 * 
 */

public class MainMenuButtonPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	final int GAP_SIZE_WIDTH = 300; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons 
		
	JPanel buttonPanel = new JPanel(); // panel for the buttons 
	GridLayout buttonLayout = new GridLayout(1,3);
	
	JButton startButton = new JButton("Start Game"); // creates the start button
	JButton quitButton = new JButton("Quit"); // creates the quit button
	JButton tutorialButton = new JButton("Tutorial"); // creates the tutorial button
	
	Dimension buttonSize =  startButton.getPreferredSize(); // sets the preferred size of buttons
	

	/**
	 * The constructor that creates an instance of the button panel. Calls the setButtonPanel 
	 * method to initialize the button panel and adds it to the screen.
	 */
	public MainMenuButtonPanel(){
		setButtonPanel(); // creates the button panel at the bottom of the screen
	}
	

	/**
	 * Sets up the button panel with a GridLayout that will contain the buttons used
	 * to start the game. Adds three buttons to the panel with action listeners to 
	 * control what happens when a button is clicked. Then adds the buttonPanel to the 
	 * PAGE.END position on the JFrame.
	 */
	private void setButtonPanel(){
		
		buttonPanel.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int)(buttonSize.getHeight()) + GAP_SIZE_HEIGHT));
		buttonPanel.setLayout(buttonLayout);
		buttonPanel.add(startButton);
		buttonPanel.add(tutorialButton);
		buttonPanel.add(quitButton);
		buttonPanel.setBackground(Color.BLUE);
		setBackground(Color.BLUE);
		add(buttonPanel);
		
		// Action Listeners for Mouse Events Clicked
		// Action performed when the start button is clicked 
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.showBoardMenu();
			}
		});
		
		// design and call the method that will make this work
		tutorialButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO implement tutorial
			}
		});
		
		// Action performed when the quit button is clicked 
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				System.exit(0);
			}
		});		
	}
	
	/**
	 * Returns the overridden size of the JComponent. Sets the preferred size of the
	 * JPanel for the button panel to sit on.
	 * 
	 * @return the preferred size of the JComponent 
	 */
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(0, 48);
		return size;
	}
}
