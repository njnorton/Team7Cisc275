package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import board.BoardController;

public class BoardMenuSideGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel sidePanel = new JPanel(); // creates the side panel for the BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel bottomPanel = new JPanel(); // adds the bottom panel to the screen
	private JPanel creaturePanel = new JPanel(); // adds the panel for describing creature panel
	private JPanel menuPanel = new JPanel(); // adds the panel for describing the selection of game play
	
	private JLabel creatureLabel = new JLabel("Select from available creatures below:");
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");
	
	protected JButton startButton = new JButton("Start Round");
	protected JButton endButton = new JButton("End Round");
	
	BoardMenuScorePanel scorePanel = 
			new BoardMenuScorePanel(0, 1000, 30, Color.WHITE); // creates the scorePanel
	BoardMenuTimerPanel timerPanel = new BoardMenuTimerPanel(45); // creates the timerPanel
	BoardController c1;

	private GridLayout creatureLayout = new GridLayout(2,4); // creates the grid for the creature buttons
	private GridLayout enemyLayout = new GridLayout(2,1); // creates the grid for the enemy buttons

	private final String[] creatureList = { "images/crab1.png", "images/horseshoeCrab1.jpg", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png",
			"images/estuaryPhoto.png", "images/estuaryPhoto.png", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png" };
	
	private final BufferedImage[] creatureImg = estuaryCreatureButtonImages(creatureList);

	public BoardMenuSideGamePanel() {
		setBackground(Color.BLACK); // sets the color of the background for the screen
		addScorePanel(); // adds the score panel for the screen
		addTimerPanel(); // adds the timer panel during game play 
		addLabelMiddleTop(); // adds a label to identify creature section
		addMiddlePanel(); // adds the middle panel for the screen
		addBottomLabel(); // adds a label to identify menu selection
		addBottomPanel(); // adds the bottom panel for the screen
		sidePanel(); // calls the method to add all components together
	}

	// adds the side panel to the screen on the East Side of BorderLayout
	private void sidePanel() {
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		add(sidePanel);
	}

	// adds the top panel to the screen with the initial amount of sand dollars
	private void addScorePanel() {
		sidePanel.add(scorePanel);
	}
	
	// adds the timer panel to the screen
	private void addTimerPanel(){
		sidePanel.add(timerPanel);
	}
	
	private void addLabelMiddleTop(){
		sidePanel.add(creaturePanel);
		creaturePanel.add(creatureLabel);
		creaturePanel.setBackground(Color.LIGHT_GRAY);
		creaturePanel.setPreferredSize(new Dimension(300, 40));
	}

	// adds the middle panel to the screen on BorderLayout East Side
	private void addMiddlePanel() {
		middlePanel.setPreferredSize(new Dimension(300, 400));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(creatureLayout);

		placeImageOnButtonsCreature();

		sidePanel.add(middlePanel);
	}
	
	private void addBottomLabel(){
		sidePanel.add(menuPanel);
		menuPanel.setPreferredSize(new Dimension(300, 40));
		menuPanel.setBackground(Color.YELLOW);
		menuPanel.add(menuInstruction);
	}
	
	// adds the bottom panel to the screen on BorderLayout East Side
	private void addBottomPanel() {
		bottomPanel.setPreferredSize(new Dimension(300, 100));
		bottomPanel.setBackground(Color.YELLOW);
		bottomPanel.setLayout(enemyLayout);
		
		bottomPanel.add(startButton);
		bottomPanel.add(endButton);
	
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.startTimer();
			}
		});
		
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPanel.stopTimer();
			}
		});
		
		sidePanel.add(bottomPanel);
	}

	// places the images on the JButtons
	private void placeImageOnButtonsCreature() {
		for (int x = 0; x < creatureList.length; x++) {
			JButton image = new JButton();
			image.setSize(55, 80);
			Image dimg = creatureImg[x].getScaledInstance(image.getWidth(), 
					image.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(dimg);
			image.setIcon(ic);
			middlePanel.add(image);
		}
	}

	// creates the buttons images on the middle panel
	private BufferedImage[] estuaryCreatureButtonImages(String[] imageList) {
		BufferedImage[] imgList = new BufferedImage[imageList.length];
		try {
			for (int x = 0; x < imageList.length; x++) {
				imgList[x] = ImageIO.read(new File(imageList[x]));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return imgList;
	}
}
