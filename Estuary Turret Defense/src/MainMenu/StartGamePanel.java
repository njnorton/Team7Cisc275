package MainMenu;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import BoardMenu.BoardMenuView;

public class StartGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	JPanel buttonPanel = new JPanel();
	GridLayout buttons = new GridLayout(1,3);
	JButton startButton = new JButton("Start Game");
	JButton quitButton = new JButton("Quit");
	JButton testButton = new JButton("test");
	
	// Constructor for the main game panel
	public StartGamePanel(){
		buttonPanel = setWindow();
		add(buttonPanel);
	}
	
	private JPanel setWindow(){
		
		JPanel layout = new JPanel();
		layout.setLayout(buttons);
		layout.add(startButton);
		layout.add(testButton);
		layout.add(quitButton);
		buttonPanel.add(layout);
		setBackground(Color.GREEN);
		
		// Action Listeners for Mouse Events Clicked
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				BoardMenuView b1 = new BoardMenuView();
			}
		});
		
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				System.exit(0);
			}
		});
		
		return layout;
	}
}
