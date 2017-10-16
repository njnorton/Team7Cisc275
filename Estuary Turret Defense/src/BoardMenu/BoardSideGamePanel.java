package BoardMenu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardSideGamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
		
	JPanel sidePanel = new JPanel();

	public BoardSideGamePanel(){
		sidePanel();	
	}
	
	private void sidePanel(){
		sidePanel.setPreferredSize(getPreferredSize());
		sidePanel.setBackground(Color.BLUE);
		add(sidePanel);
	}
	
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(500,200);		
		return size;
	}
}
