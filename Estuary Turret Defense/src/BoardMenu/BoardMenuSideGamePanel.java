package BoardMenu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BoardMenuSideGamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
		
	JPanel sidePanel = new JPanel();
	BoardMenuScorePanel scorePanel = new BoardMenuScorePanel(1000, Color.WHITE);
	JPanel middlePanel = new JPanel();
	JPanel bottomPanel = new JPanel();
	
	public BoardMenuSideGamePanel(){
		addScorePanel(); // adds the score panel for the screen
		addMiddlePanel(); // adds the middle panel for the screen
		addBottomPanel(); // adds the bottom panel for the screen
		sidePanel(); // calls the method to add all components together 
	}
	
	private void sidePanel(){
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		add(sidePanel);
	}
	
	private void addScorePanel(){
		sidePanel.add(scorePanel);	
	}
	
	private void addMiddlePanel(){
		middlePanel.setPreferredSize(new Dimension(300, 350));
		middlePanel.setBackground(Color.RED);
		sidePanel.add(middlePanel);
	}
	
	private void addBottomPanel(){
		bottomPanel.setPreferredSize(new Dimension(300, 350));
		bottomPanel.setBackground(Color.YELLOW);
		sidePanel.add(bottomPanel);
	}
}
