package boardMenuView;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class BoardMenuInfoPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JPanel informationPanel = new JPanel();
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
		
		creaturePanel.add(creatureName); 		
		creaturePanel.add(creature);
		
		factPanel.add(creatureFact);
		factPanel.add(fact);
		
		costPanel.add(creatureCost);
		costPanel.add(cost);
		
		damagePanel.add(creatureDamage);
		damagePanel.add(damage); 
		
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
