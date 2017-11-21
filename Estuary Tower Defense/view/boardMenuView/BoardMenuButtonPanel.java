package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameController.GameController;

/**
 * Sets up the button panel that is seen on the main menu of the game. There is also
 * the commands for the different buttons to control different aspects of the game in
 * the different states it can be in. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * int GAP_SIZE_WIDTH: sets the total width of the buttons across the screen
 * int GAP_SIZE_HEIGHT: sets the height of the buttons on the screen
 * JPanel buttonPanel: the base panel that the buttons will sit on 
 * JButton quitButton: the button that controls what happens when a user wants to exit
 * JButton startButton: the button that controls what happens when a user wants to start the game 
 * JButton saveButton: the button that shows the leaderboard to view the high scores in the game 
 * JLabel menuInstruction:  the label that gives information about how to start the game 
 * Dimension buttonSize: the preferred size of the buttons to scale to the screen
 */

public class BoardMenuButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	final int GAP_SIZE_WIDTH = 1000; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons

	private JPanel buttonPanel = new JPanel();
	
	private JButton quitButton = new JButton("Return to Main Menu");
	protected JButton startButton = new JButton("Start Round"); // creates the start round button	
	private JButton saveButton = new JButton("Save"); // saves the stuff to a leaderBoard
	
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");

	private Dimension buttonSize = quitButton.getPreferredSize(); // sets the preferred size of buttons
	
	/**
	 * Sets up the button panel on the screen for the main menu. Also, contains action
	 * listeners to control what happens when a particular button is clicked in the game.
	 * The placement of the button panel is at the PAGE_END section of the JFrame.
	 */
	public BoardMenuButtonPanel(){
		buttonPanel.setLayout(new GridLayout(1, 4)); // sets the layout of the button panel
		buttonPanel.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int) (buttonSize.getHeight()) + GAP_SIZE_HEIGHT)); // sets the preferred size of the button panel
		buttonPanel.setBackground(Color.RED); // sets the background color of the button panel
		setBackground(Color.RED); // sets the background of the main panel for the button panel
		menuInstruction.setFont(new Font(Font.DIALOG, Font.BOLD, 13)); // sets the font for the menu instruction label
		
		buttonPanel.add(startButton); // adds the start button to the panel
		buttonPanel.add(saveButton); // adds the save button to the panel
		buttonPanel.add(quitButton); // adds the exit button to the panel
		buttonPanel.add(menuInstruction); // adds the menu instruction label to the screen
				
		add(buttonPanel);
		
		// adds action listener on the button click for the start button 
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false); // disables the button during the rounds
				//GameController.setIsRoundActive(true); again used for uncertainty in MVC-ness
				GameController.view.boardMenu.sidePanel.timerPanel.startTimer(); // starts the time event for game play	
					}
				});
		
		// adds action listener on the button click for the save button
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				GameController.showLeaderBoard();
			}
		});
		
		// adds action listener on the button click for the quit button 
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.showMainMenu();
				startButton.setEnabled(true);
				GameController.view.boardMenu.sidePanel.timerPanel.stopTimer(); // starts the time event for game play	
			}
		});
	}
	
	/**
	 * Returns back the preferred size of the JComponent. Sets the preferred size of the 
	 * JPanel to fit onto the JFrame of the board menu.
	 * 
	 * @return the preferred size of the JComponent 
	 */
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(0, 48);
		return size;
	}
}
