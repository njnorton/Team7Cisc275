package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import unit.turret.TurretModel;

public class BoardMenuScorePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Font firstLabelFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font size for head label
	private Font secondLabelFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font for label
	
	private int startScore = 0; // what the score is set to in the beginning of the game 
	private int currentScore = 0; // what the current score of the game is
	private int startSandDollars = 0; // how many sand dollars started with
	private int remainingSandDollars = 0; // how many sand dollars remaining 
	private int startHealth = 0; // how much health that you have in the beginning of game 
	private int remainingHealth = 0; // how much health is left during the game
	
	private JLabel scoreTotalLabel = new JLabel("0"); // label for score total
	private JLabel sandDollarsLabel = new JLabel("0"); // label for sand dollars
	private JLabel healthLeftLabel = new JLabel("0"); // label for health left 
	
	// constructor for the score panel
	public BoardMenuScorePanel(int startScore, int startSandDollars, int startHealth, Color panelColor){
		this.startScore = startScore;
		this.startSandDollars = startSandDollars; 
		this.startHealth = startHealth;
		
		currentScore = startScore;
		remainingSandDollars = startSandDollars;
		remainingHealth = startHealth;
		
		setPreferredSize(new Dimension(300, 125)); // sets the size of the panel
		setBackground(panelColor); // set the background color
		setLayout(new GridLayout(3,2)); // sets a new grid layout 
		
		// Score Label
		JLabel scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(firstLabelFont);
		add(scoreLabel);
		
		// Total Score Label
		scoreTotalLabel.setFont(secondLabelFont);
		scoreTotalLabel.setText("" + startScore);
		add(scoreTotalLabel);
		
		// Remaining SandDollars
		JLabel sandDollars = new JLabel("SandDollars Left: ");
		sandDollars.setFont(firstLabelFont);
		add(sandDollars);
		
		// Total Remaining SandDollars that are left
		sandDollarsLabel.setFont(secondLabelFont);
		sandDollarsLabel.setAlignmentY(RIGHT_ALIGNMENT);
		sandDollarsLabel.setText("" + remainingSandDollars);
		add(sandDollarsLabel);
		
		// Health Left
		JLabel healthLabel = new JLabel("Health Left: ");
		healthLabel.setFont(firstLabelFont);
		add(healthLabel);
		
		// Total Health that is left 
		healthLeftLabel.setFont(secondLabelFont);
		healthLeftLabel.setText("" + remainingHealth);
		add(healthLeftLabel);
	}
	
	// sets the score on the panel
	public void updateScore(int score){
		currentScore += score;
		scoreTotalLabel.setText("" + currentScore);
	}
	
	// sets the sand dollars on the panel
	public void updateSandDollars(int sandDollars){
		remainingSandDollars += sandDollars; // adds the appropriate amount of sand dollars 
		sandDollarsLabel.setText("" + remainingSandDollars); // updates the label 
	}
	
	// sets the remaining health on the panel
	public void updateHealth(int healthLost){
		remainingHealth -= healthLost;
		healthLeftLabel.setText("" + remainingHealth);
	}
	
	// allows for the purchase of items from the buttons 
	public void purchaseItem(TurretModel model){
		remainingSandDollars -= model.getPrice();
		sandDollarsLabel.setText("" + remainingSandDollars);
	}
	
	// resets the score on the panel to the initial state
	public void reset(){
		currentScore = startScore;
		remainingSandDollars = startSandDollars; // resets to the initial sand dollars started with
		remainingHealth = startHealth;
		
		scoreTotalLabel.setText("" + currentScore); // updates the label 
		sandDollarsLabel.setText("" + remainingSandDollars); // updates the label 
		healthLeftLabel.setText("" + remainingHealth); // updates the label
	}
}
