package boardMenuView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	
	public BoardMenuInfoPanel(){
		informationPanel.setPreferredSize(new Dimension(260,225));
		informationPanel.setLayout(new GridLayout(5,1));
		creaturePanel.setLayout(new BoxLayout(creaturePanel, BoxLayout.X_AXIS));
		factPanel.setLayout(new BoxLayout(factPanel, BoxLayout.X_AXIS));
		costPanel.setLayout(new BoxLayout(costPanel, BoxLayout.X_AXIS));
		damagePanel.setLayout(new BoxLayout(damagePanel, BoxLayout.X_AXIS));
		rangePanel.setLayout(new BoxLayout(rangePanel, BoxLayout.X_AXIS));
		fact.setEditable(false); // disables the text area from being written in and overridden
		
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
		creature.setText("30");
	}
	
	public void setCreatureText(String s){
		creature.setText("" + s);
	}
	
	// sets the text area field of the information panel with a fact description 
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
	
	public void setCost(int costCreature){
		cost.setText("" + costCreature);
	}
	
	public void setDamage(int damageCreature){
		damage.setText("" + damageCreature);
	}
	
	public void setRange(int rangeCreature){
		range.setText("" + rangeCreature);
	}
}
