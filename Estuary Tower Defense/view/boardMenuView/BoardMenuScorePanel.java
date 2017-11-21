package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.PlayerModel;
import unit.TowerModel;

/**
 * Makes the score panel that is located on the side menu panel to give information about 
 * current score, health left, and sand dollars that are left. Will make updates during the 
 * game to keep the information current for the user playing the game. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * Font firstLabelFont: the font used for the labels on the left side of the GridLayout
 * Font secondLabelFont: the font used for the labels on the right side of the GridLayout
 * int score: the current score of the game 
 * int sandDollars: the current amount of sand dollars that are remaining in the game 
 * int health: the current amount of health that is left in the game 
 * JLabel scoreTotalLabel: the label that is used to display the current score of the game 
 * JLabel sandDollarsLabel: the label that is used to display the current amount of sand dollars that are left 
 * JLabel healthLeftLabel: the label that is used to display the current amount of health left in the game 
 */

public class BoardMenuScorePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Font firstLabelFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font size for head label
	private Font secondLabelFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font for label
	
	private static int score; 
	private static int sandDollars;
	private static int health; 
		
	private JLabel scoreTotalLabel = new JLabel("0"); // label for score total
	private JLabel sandDollarsLabel = new JLabel("0"); // label for sand dollars
	private JLabel healthLeftLabel = new JLabel("0"); // label for health left 
				
	/**
	 * Constructor that sets up the entire score panel seen on the game side panel. 
	 * Is able to take in a particular color and will make that the color of the score 
	 * panel for user appeal. 
	 * 
	 * @param panelColor the specified color that the user wants the score panel to be 
	 */
	public BoardMenuScorePanel(Color panelColor){
		setPreferredSize(new Dimension(260, 90)); // sets the size of the panel
		setBackground(panelColor); // set the background color
		setLayout(new GridLayout(3,2)); // sets a new grid layout 
		
		// Score Label
		JLabel scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(firstLabelFont);
		add(scoreLabel);
		
		// Total Score Label
		scoreTotalLabel.setFont(secondLabelFont);
		add(scoreTotalLabel);
		
		// Remaining SandDollars
		JLabel sandDollars = new JLabel("SandDollars: ");
		sandDollars.setFont(firstLabelFont);
		add(sandDollars);
		
		// Total Remaining SandDollars that are left
		sandDollarsLabel.setFont(secondLabelFont);
		sandDollarsLabel.setAlignmentY(RIGHT_ALIGNMENT);
		add(sandDollarsLabel);
		
		// Health Left
		JLabel healthLabel = new JLabel("Health Left: ");
		healthLabel.setFont(firstLabelFont);
		add(healthLabel);
		
		// Total Health that is left 
		healthLeftLabel.setFont(secondLabelFont);
		add(healthLeftLabel);
	}
	
	/**
	 * Updates the current score in the game based on what action is taken in the game. 
	 * Will update the label with the information that it is given. 
	 * 
	 * @param playerScore the amount that the score goes up with an update to the game 
	 */
	public void updateScore(int playerScore){
		score += playerScore;
		scoreTotalLabel.setText("" + score);
	}
	
	/**
	 * Updates the current amount of sand dollars based on an action that is taken in the game. 
	 * This is used for the actions when a turret kills one of the enemies in the game. 
	 * 
	 * @param playerMoney the amount of money that is added to the game to update the score panel
	 */
	public void updateSandDollars(int playerMoney){
		sandDollars += playerMoney; // adds the appropriate amount of sand dollars 
		sandDollarsLabel.setText("" + sandDollars); // updates the label 
	}
	
	/**
	 * Updates the current amount of health left when an enemy passes through the estuary 
	 * without being killed. The total amount of health left is based upon the user settings 
	 * of how much health is taken off. 
	 * 
	 * @param healthLost the amount that the health decreases when an enemy passes through the 
	 * 					 estuary without being killed.
	 */
	public void updateHealth(int healthLost){
		health -= healthLost;
		healthLeftLabel.setText("" + health);
	}
	
	/**
	 * Updates the total amount of sand dollars that are left when a user makes a purchase in 
	 * the game rounds. It takes in the player model to extract the total sand dollars that are 
	 * left for the user and the turret model to obtain the cost of a particular creature. 
	 *  
	 * @param mod the player model information needed to update the label 
	 * @param model the turret type information needed to subtract the cost of obtaining the creature
	 */
	public void purchaseItem(PlayerModel mod, TowerModel model){
		int money = mod.getMoney();
		System.out.println(money);
		sandDollars =  money - model.getPrice();
		System.out.println(sandDollars);
		sandDollarsLabel.setText("" + sandDollars);
	}
	
	/**
	 * Gets the total number of sandDollars that are left in the game 
	 * 
	 * @return the amount of sandDollars that are left in the current game
	 */
	public int getSandDollars(){
		return sandDollars;
	}

	public void setScore(int playerScore) {
		score = playerScore;
		scoreTotalLabel.setText("" + score);
	}

	public void setSandDollars(int playerMoney) {
		sandDollars = playerMoney;
		sandDollarsLabel.setText("" + sandDollars);
	}

	public void setHealth(int playerHealth) {
		health = playerHealth;
		healthLeftLabel.setText("" + health);
	}
}
