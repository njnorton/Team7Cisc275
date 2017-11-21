package leaderBoardView;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	
	private JPanel centerPanel = new JPanel();
	private JPanel buttonPanel = new JPanel();
	
	private JButton exitButton = new JButton("Exit");

	/**
	 * Constructor that sets up and creates instances of the classes needed to make 
	 * the leaderboard view. Makes 2 calls to seperate methods to initalize the panels 
	 * and to make the frame work underneath the JFrame.
	 */
	public LeaderBoardView(){
		title = new MainMenuTitlePanel("Estuary Tower Defense LeaderBoard");
		
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
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		// For Testing Purposes Only!
		JLabel testLabel = new JLabel();
		JLabel titleLabel = new JLabel();
		
		String name = "Thomas Pennington";
		int score = 100;
		Date date = new Date();
		
		String testRun = String.format("%-35s%-29d%-25s", name, score, date); // Stays for format! DO NOT DELETE
		String testTitle = String.format("%20s%28s%50s", "Name", "Score", "Date"); // Stay for format! DO NOT DELETE
		
		testLabel.setText(""+ testRun);
		titleLabel.setText("" + testTitle);
		
		centerPanel.add(titleLabel);
		centerPanel.add(testLabel);
		
		// Stays for implementation one line below
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
