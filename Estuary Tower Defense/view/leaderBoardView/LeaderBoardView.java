package leaderBoardView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import mainMenuView.MainMenuTitlePanel;

/**
 * Creates the leaderboard for the game with the top 10 scorers that play the game. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

public class LeaderBoardView extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private final int LEADER_BOARD_WIDTH = 700;
	private final int LEADER_BOARD_HEIGHT = 500;
	
	private MainMenuTitlePanel title;
	public LeaderBoardCenterPanel centerPanel;
	
	private JPanel buttonPanel = new JPanel();
	
	private JButton exitButton = new JButton("Exit");

	/**
	 * Constructor that sets up and creates instances of the classes needed to make 
	 * the leaderboard view. Makes 2 calls to seperate methods to initalize the panels 
	 * and to make the frame work underneath the JFrame.
	 */
	public LeaderBoardView(){
		title = new MainMenuTitlePanel("Estuary Tower Defense LeaderBoard");
		centerPanel = new LeaderBoardCenterPanel();
		
		initGUI();
		setupLeaderBoard();
	}
	
	/**
	 * Sets up all of the panels so they are placed in the correct spot in the JFrame 
	 * on the screen. There are a total of 3 panels that are placed in their respective 
	 * locations on the screen.  
	 */
	private void initGUI(){
		// adds the title to the screen
		add(title, BorderLayout.PAGE_START);
		
		// adds the centerpanel to the screen
		add(centerPanel, BorderLayout.CENTER);
		
		// adds the buttonPanel to the screen
		buttonPanel.setSize(new Dimension(0,48));
		buttonPanel.setBackground(Color.RED);
		buttonPanel.add(exitButton);
		add(buttonPanel, BorderLayout.PAGE_END);
	}
	
	/**
	 * Makes the entire frame that the components of the leaderboard view will sit on. Sets 
	 * up all of the properties needed to make the view work correctly when it loads.
	 */
	private void setupLeaderBoard(){
		setTitle("LeaderBoard");
		setSize(LEADER_BOARD_WIDTH, LEADER_BOARD_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
