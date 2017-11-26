package boardMenuView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Creates the information panel located on the side panel of the game. It displays facts, 
 * amounts, and statistics needed for the game for the user playing the game. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * JPanel informationPanel: the base for the main information panel for all components to sit on
 * JPanel creaturePanel: the panel used to hold information about the name of a creature 
 * JPanel factPanel: the panel used to hold information about a fact regarding a particular creature
 * JPanel costPanel: the panel used to hold information about the cost of obtaining different creatures 
 * JPanel damagePanel: the panel used to hold information about the damage that each creature has 
 * JPanel rangePanel: the panel used to hold information about the range that a particular creature has 
 * JLabel creatureName: the label used to provide what the name of a creature heading
 * JLabel creatureFact: the label used to provide a creature fact heading
 * JLabel creatureCost: the label used to provide the creature cost heading
 * JLabel creatureDamage: the label used to provide the creature damage heading 
 * JLabel creatureRange: the label used to provide the creature range heading 
 * JLabel creature: the label used to display the name of the creature 
 * JTextArea fact: the text area used to display a fact about a particular creature 
 * JLabel cost: the label used to display the cost of a creature 
 * JLabel damage: the label used to display the damage for each creature 
 * JLabel range: the label used to display the range that a particular creature has 
 * Font firstLabelFont: the font used for the first labels used on the left side 
 * Font secondLabelFont: the font used for the second labels used on the right side 
 * double DIVIDE_FACTOR: the percentage of the line that will be displayed for the text 
 * 						 fact before new line created
 */

public class BoardMenuInfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JPanel informationPanel = new JPanel(); // the main information panel 
	private JPanel creaturePanel = new JPanel(); 
	private JPanel factPanel = new JPanel();
	private JPanel costPanel = new JPanel();
	private JPanel damagePanel = new JPanel();
	private JPanel rangePanel = new JPanel();
	
	private JLabel creatureName = new JLabel("Creature Name: "); // Label to give the name of the creature selected
	private JLabel creatureFact = new JLabel("Creature Fact: "); // Label to give the fact associated with the creature selected
	private JLabel creatureCost = new JLabel("Creature Cost: ");
	private JLabel creatureDamage = new JLabel("Creature Damage: ");
	private JLabel creatureRange = new JLabel("Creature Range: ");
	
	private JLabel creature = new JLabel(""); 
	private JTextArea fact = new JTextArea(); 
	private JLabel cost = new JLabel(""); 
	private JLabel damage = new JLabel("");
	private JLabel range = new JLabel(""); 
	
	private Font firstLabelFont = new Font(Font.DIALOG, Font.PLAIN, 14);
	private Font secondLabelFont = new Font(Font.DIALOG, Font.BOLD, 14);
		
	private final double DIVIDE_FACTOR = .70; // tells when the lines should be split
	
	/**
	 * Constructor that sets up the entire information panel with the different components.
	 * It also will add the different components to the JPanel to make the information panel.
	 */
	public BoardMenuInfoPanel(){
		informationPanel.setPreferredSize(new Dimension(260,225));
		informationPanel.setLayout(new GridLayout(5,1));
		creaturePanel.setLayout(new BoxLayout(creaturePanel, BoxLayout.X_AXIS));
		factPanel.setLayout(new BoxLayout(factPanel, BoxLayout.X_AXIS));
		costPanel.setLayout(new BoxLayout(costPanel, BoxLayout.X_AXIS));
		damagePanel.setLayout(new BoxLayout(damagePanel, BoxLayout.X_AXIS));
		rangePanel.setLayout(new BoxLayout(rangePanel, BoxLayout.X_AXIS));
		fact.setEditable(false); // disables the text area from being written in and overridden
		fact.setLineWrap(true);
		
		// sets the Fonts for the first set of labels in the grid 
		creatureName.setFont(firstLabelFont); creatureFact.setFont(firstLabelFont);
		creatureCost.setFont(firstLabelFont); creatureDamage.setFont(firstLabelFont);
		creatureRange.setFont(firstLabelFont);
		
		// sets the Fonts for the second set of labels in the grid 
		creature.setFont(secondLabelFont); cost.setFont(secondLabelFont); 
		damage.setFont(secondLabelFont); range.setFont(secondLabelFont);
		
		// adds the creature panel and labels to the grid
		creaturePanel.add(creatureName); 		
		creaturePanel.add(creature);
		
		// adds the fact panel and labels to the grid 
		factPanel.add(creatureFact);
		factPanel.add(fact);
		
		// adds the cost panel and labels to the grid 
		costPanel.add(creatureCost);
		costPanel.add(cost);
		
		// adds the damage panel and labels to the grid 
		damagePanel.add(creatureDamage);
		damagePanel.add(damage); 
		
		// adds the range panel and labels to the grid 
		rangePanel.add(creatureRange);
		rangePanel.add(range);
		
		// adds all additional panels to the screen to give out information 
		informationPanel.add(creaturePanel);
		informationPanel.add(factPanel);
		informationPanel.add(costPanel);
		informationPanel.add(damagePanel);
		informationPanel.add(rangePanel);

		add(informationPanel);
	}
	
	/**
	 * Sets the label equal to the creature that is selected based upon the button clicked. 
	 * 
	 * @param s the text that will be entered to set the name of the creature 
	 */
	public void setCreatureText(String s){
		creature.setText("" + s);
	}
	
	/**
	 * Sets the creature fact based upon what fact is given for a particular creature. 
	 * When a condition is met for a new line requirement, this will take care of this 
	 * automatically and properly display in the text area. 
	 * 
	 * @param text the line of text that will be a given creatures fact 
	 */
	public void setFactText(String text) {
		int textLength = text.length();
        String temp = "";
        String newSentence = "";
        
        String[] wordList = text.split(" ");
               
        for (String word : wordList) {
            if ((temp.length() + word.length()) < textLength*DIVIDE_FACTOR) {  
                temp += " " + word;
            } else {
            	newSentence += temp +"\n"; // add new line character
                temp = word;
            }
        }
		fact.setText("" + (newSentence.replaceFirst(" ", "")+ temp));
    }
	
	/**
	 * Sets the label to a given creatures cost when a particular creature is clicked on.
	 * 
	 * @param costCreature the cost of the creature that is passed in
	 */
	public void setCost(int costCreature){
		cost.setText("" + costCreature);
	}
	
	/**
	 * Sets the label to a given creatures damage when a particular creature is clicked on.
	 * 
	 * @param damageCreature the damage that a particular creature has 
	 */
	public void setDamage(int damageCreature){
		damage.setText("" + damageCreature);
	}
	
	/**
	 * Sets the label to a given creatures range when a particular creature is clicked on.
	 * 
	 * @param rangeCreature the range that a particular creature has 
	 */
	public void setRange(int rangeCreature){
		range.setText("" + rangeCreature);
	}
}
