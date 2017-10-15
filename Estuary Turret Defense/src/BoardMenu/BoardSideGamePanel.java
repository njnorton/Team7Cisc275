package BoardMenu;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardSideGamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	BoardMenuView menu;
	
	JPanel sidePanel = new JPanel();

	public BoardSideGamePanel(){
		sidePanel = sidePanel();
		add(sidePanel);
	}
	
	private JPanel sidePanel(){
		JPanel side = new JPanel();
		side.setBackground(Color.BLUE);
		side.setPreferredSize(getPreferredSize());
		sidePanel.add(side);
		
		return side;
	}
	
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(200,48);		
		return size;
	}
}
