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

public class BoardMenuButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	final int GAP_SIZE_WIDTH = 1000; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons

	private JPanel buttonPanel = new JPanel();
	
	private JButton exitButton = new JButton("Return to Main Menu");
	private JButton startButton = new JButton("Start Round"); // creates the start round button	
	private JButton saveButton = new JButton("Save"); // saves the stuff to a leaderBoard
	
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");

	Dimension buttonSize = exitButton.getPreferredSize(); // sets the preferred size of buttons
	
	// Constructor
	public BoardMenuButtonPanel(){
		buttonPanel();
	}
		
	// Creates the button panel for the bottom of the screen
	private void buttonPanel() {
		buttonPanel.setLayout(new GridLayout(1, 4));
		buttonPanel.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int) (buttonSize.getHeight()) + GAP_SIZE_HEIGHT));
		buttonPanel.setBackground(Color.RED);
		setBackground(Color.RED);
		menuInstruction.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
		
		buttonPanel.add(startButton);
		buttonPanel.add(saveButton);
		buttonPanel.add(exitButton);
		buttonPanel.add(menuInstruction);
				
		add(buttonPanel);
		
		// adds action listener on the button click for the game
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false); // disables the button during the rounds
				//endButton.setEnabled(true); // enables the button during the rounds
				//GameController.setIsRoundActive(true); again used for uncertainty in MVC-ness
				GameController.view.boardMenu.sidePanel.timerPanel.startTimer(); // starts the time event for game play	
					}
				});
		
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				//TODO add code to make this do whatever (LeaderBoard)
			}
		});
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GameController.showMainMenu();
				startButton.setEnabled(true);
				GameController.view.boardMenu.sidePanel.timerPanel.stopTimer(); // starts the time event for game play	
			}
		});
	}
	
	// sets the preferred size for the JPanel
		public Dimension getPreferredSize(){
			Dimension size = new Dimension(0, 48);
			return size;
		}
}
