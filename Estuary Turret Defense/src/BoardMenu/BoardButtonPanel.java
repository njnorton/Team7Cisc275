package BoardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardButtonPanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	final int GAP_SIZE_WIDTH = 20; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons

	JPanel buttonPanel = new JPanel();
	JButton exitButton = new JButton("Return to Main Menu");

	Dimension buttonSize = exitButton.getPreferredSize(); // sets the preferred size of buttons
	
	// Constructor
	public BoardButtonPanel(){
		buttonPanel();
	}
	
	// Creates the button panel for the bottom of the screen
	private void buttonPanel() {
		buttonPanel.setLayout(new GridLayout(1, 2));
		buttonPanel.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int) (buttonSize.getHeight()) + GAP_SIZE_HEIGHT));
		buttonPanel.setBackground(Color.CYAN);
		setBackground(Color.CYAN);
		buttonPanel.add(exitButton);
		add(buttonPanel);
	}
}
