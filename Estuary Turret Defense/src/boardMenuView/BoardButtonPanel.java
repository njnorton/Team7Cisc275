package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import MainMenu.InitiateGameStartView;

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
		buttonPanel.setBackground(Color.RED);
		setBackground(Color.RED);
		buttonPanel.add(exitButton);
		add(buttonPanel);
		
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InitiateGameStartView v1 = new InitiateGameStartView();
			}
		});
	}
	
	// sets the preferred size for the JPanel
		public Dimension getPreferredSize(){
			Dimension size = new Dimension(0, 48);
			return size;
		}
}
