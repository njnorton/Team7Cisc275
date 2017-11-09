package mainMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import gameController.GameController;

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
	

	// Constructor for the main game panel
	public MainMenuButtonPanel(){
		setButtonPanel(); // creates the button panel at the bottom of the screen
	}
	
	// creates the panel for the Button Panel at the Page End Location
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
	
	// sets the preferred size for the JPanel
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(0, 48);
		return size;
	}
}
