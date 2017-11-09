package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.PlayerModel;
import unit.TowerModel;

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
				
	// constructor for the score panel
	public BoardMenuScorePanel(Color panelColor){
		setPreferredSize(new Dimension(300, 125)); // sets the size of the panel
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
		JLabel sandDollars = new JLabel("SandDollars Left: ");
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
	
	// sets the score on the panel
	public void updateScore(int playerScore){
		score += playerScore;
		scoreTotalLabel.setText("" + score);
	}
	
	// sets the sand dollars on the panel
	public void updateSandDollars(int playerMoney){
		sandDollars += playerMoney; // adds the appropriate amount of sand dollars 
		sandDollarsLabel.setText("" + sandDollars); // updates the label 
	}
	
	// sets the remaining health on the panel
	public void updateHealth(int healthLost){
		health -= healthLost;
		healthLeftLabel.setText("" + health);
	}
	
	// allows for the purchase of items from the buttons 
	public void purchaseItem(PlayerModel mod, TowerModel model){
		int money = mod.getMoney();
		System.out.println(money);
		sandDollars =  money - model.getPrice();
		System.out.println(sandDollars);
		sandDollarsLabel.setText("" + sandDollars);
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
