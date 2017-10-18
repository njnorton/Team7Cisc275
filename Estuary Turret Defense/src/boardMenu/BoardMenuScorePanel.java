package boardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardMenuScorePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private Font sandHeadFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font size for head label
	private Font sandDollarsLabelFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font for sand dollars
	
	private int startSandDollars = 0; // how many sand dollars started with
	private int remainingSandDollars = 0; // how many sand dollars remaining 
	
	private JLabel sandDollarsLabel = new JLabel("0"); // label for sand dollars
	private JLabel scoreTotalLabel = new JLabel("0"); // label for sand dollars
	private JLabel healthLabel = new JLabel("0"); // label for sand dollars

	
	// constructor for the score panel
	public BoardMenuScorePanel(int startSandDollars, Color panelColor){
		this.startSandDollars = startSandDollars; 
		remainingSandDollars = startSandDollars;
		
		setPreferredSize(new Dimension(300, 100)); // sets the size of the panel
		setBackground(panelColor); // set the background color
		setLayout(new GridLayout(3,2));
		
		// Score Label
		JLabel scoreLabel = new JLabel("Score: ");
		scoreLabel.setFont(sandHeadFont);
		add(scoreLabel);
		
		// Remaining SandDollars
		JLabel sandDollars = new JLabel("SandDollars Remaining: ");
		sandDollars.setFont(sandHeadFont);
		add(sandDollars);
		
	}
	
	// sets the score on the panel
	public void setScore(int sandDollars){
		remainingSandDollars += sandDollars; // adds the appropriate amount of sand dollars 
		sandDollarsLabel.setText("" + remainingSandDollars); // updates the label 
	}
	
	// resets the score on the panel to the initial amount of sand dollars
	public void resetScore(){
		remainingSandDollars = startSandDollars; // resets to the intial sand dollars started with
		sandDollarsLabel.setText("" + remainingSandDollars); // updates the label 
	}
}
