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
import javax.swing.Icon;
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
	
	private JButton startButton = new JButton("Start Round");
	private JButton endButton = new JButton("End Round");
	
	public BoardMenuScorePanel scorePanel = new BoardMenuScorePanel(0, 100, 30, Color.WHITE);
	public BoardMenuTimerPanel timerPanel;
	public BoardMenuCenterPanel cen = new BoardMenuCenterPanel(); // allows access to center panel
	public BoardController c1 = new BoardController(); // gives access to the controller;

	private GridLayout creatureLayout = new GridLayout(2,4); // creates the grid for the creature buttons
	private GridLayout enemyLayout = new GridLayout(2,1); // creates the grid for the enemy buttons

	private final String[] creatureList = { "images/crab1.png", "images/horseshoeCrab1.jpg", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png",
			"images/estuaryPhoto.png", "images/estuaryPhoto.png", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png" };
	
	protected final BufferedImage[] creatureImg = estuaryCreatureButtonImages(creatureList);
	final int rows = 2;
	final int cols = 4;
	final int timeOnClock = 45; // how much time is on the clock 
	final JButton gameButtons[][] = new JButton[rows][cols];
	
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
		timerPanel = new BoardMenuTimerPanel(timeOnClock); // creates the timerPanel
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
				c1.startRound();
				timerPanel.startTimer();
			}
		});
		
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				c1 = new BoardController();
				//c1.endRound();
				scorePanel.reset();
				timerPanel.stopTimer();
				timerPanel.reset();
			}
		});
		
		sidePanel.add(bottomPanel);
	}

	// places the images on the JButtons
	private void placeImageOnButtonsCreature() {
		
		int z = 0;
		for(int x = 0; x < rows; x++){
			for(int y = 0; y < cols; y++){
				gameButtons[x][y] = new JButton();
				
				gameButtons[x][y].setSize(55, 80);
				Image dimg = creatureImg[z].getScaledInstance(gameButtons[x][y].getWidth(),
						gameButtons[x][y].getHeight(), Image.SCALE_SMOOTH);
				ImageIcon img = new ImageIcon(dimg);
				gameButtons[x][y].setIcon(img);
				z++;
				middlePanel.add(gameButtons[x][y]);
				gameButtons[x][y].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						for(int x = 0; x < rows; x++){
							for(int y = 0; y < cols; y++){
								if(e.getSource() == gameButtons[x][y]){
									Icon i = gameButtons[x][y].getIcon();
									i.paintIcon(cen.centerPanel, getGraphics(), 120, 203);
								}
							}
						}				
					}
				});
			}
		}

	}

	// creates the buttons images on the middle panel
	protected BufferedImage[] estuaryCreatureButtonImages(String[] imageList) {
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
