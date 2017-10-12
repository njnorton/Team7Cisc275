package MainMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JPanel;

import BoardMenu.BoardMenuView;

public class StartGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	final int GAP_SIZE_WIDTH = 300; // sets the width of the JButtons
	final int GAP_SIZE_HEIGHT = 10; // sets the height of the JButtons 
	final String IMAGE_FILE = "estuaryPhoto.png";
	
	JPanel buttonPanel = new JPanel(); // panel for the buttons 
	JPanel imagePanel = new JPanel();
	GridLayout buttons = new GridLayout(1,3);
	
	JButton startButton = new JButton("Start Game"); // creates the start button
	JButton quitButton = new JButton("Quit"); // creates the quit button
	JButton tutorialButton = new JButton("Tutorial"); // creates the tutorial button
	
	Dimension buttonSize =  startButton.getPreferredSize(); // sets the preferred size of buttons
	
	BufferedImage image; // creates for the file of image selected 
	
	// Constructor for the main game panel
	public StartGamePanel(){
		buttonPanel = setWindow();
		add(buttonPanel);
	}
	
	// creates the panel for the Button Panel at the Page End Location
	private JPanel setWindow(){
		
		JPanel layout = new JPanel();
		layout.setPreferredSize(new Dimension((int) (buttonSize.getWidth()) + GAP_SIZE_WIDTH,
				(int)(buttonSize.getHeight()) + GAP_SIZE_HEIGHT));
		layout.setLayout(buttons);
		layout.add(startButton);
		layout.add(tutorialButton);
		layout.add(quitButton);
		buttonPanel.add(layout);
		layout.setBackground(Color.GREEN);
		setBackground(Color.GREEN);
		
		// Action Listeners for Mouse Events Clicked
		// Action performed when the start button is clicked 
		startButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				BoardMenuView b1 = new BoardMenuView(); // calls the main board for interaction
			}
		});
		
		// Action performed when the quit button is clicked 
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
				System.exit(0);
			}
		});
		
		return layout;
	}
	
	// sets the preferred size for the JPanel
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(0, 48);
		return size;
	}
}
