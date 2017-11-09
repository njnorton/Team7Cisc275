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
	
	public JLabel creatureN = new JLabel("The creature is a Crab"); // temporary
	public JTextArea fact = new JTextArea(); // temporary
	public JLabel cost = new JLabel("30"); // temporary
	public JLabel damage = new JLabel("100"); // temporary
	public JLabel range = new JLabel("2"); // temporary
	
	String factU = "Estuary is cool and crabs love to eat";
	
	final double DIVIDE_FACTOR = .70;
	
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
		creaturePanel.add(creatureN);
		
		factPanel.add(creatureFact);
		factPanel.add(fact);
		fact.setText("" + setText(factU));
		
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
	}
	
	public String setText(String text) {
		int textLength = text.length();
        String temp = "";
        String sentence = "";

        String[] array = text.split(" ");
        
        for (String word : array) {
            if ((temp.length() + word.length()) < textLength*DIVIDE_FACTOR) {  // create a temp variable and check if length with new word exceeds textview width.
                temp += " "+ word;
            } else {
                sentence += temp +"\n"; // add new line character
                temp = word;
            }
        }
        return (sentence.replaceFirst(" ", "")+temp);
    }
}
