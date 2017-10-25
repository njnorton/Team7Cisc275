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

import game.GameController;

public class BoardMenuSideGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private final static int TIME_ON_CLOCK = 45; // how much time is on the clock 
	
	private final String[] creatureList = { "images/crab1.png", "images/horseshoeCrab1.jpg", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png",
			"images/estuaryPhoto.png", "images/estuaryPhoto.png", 
			"images/estuaryPhoto.png", "images/estuaryPhoto.png" };
	
	private final BufferedImage[] creatureImg = estuaryCreatureButtonImages(creatureList);

	private JPanel sidePanel = new JPanel(); // creates the side panel for the BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel bottomPanel = new JPanel(); // adds the bottom panel to the screen
	private JPanel creaturePanel = new JPanel(); // adds the panel for describing creature panel
	private JPanel menuPanel = new JPanel(); // adds the panel for describing the selection of game play
	
	private JLabel creatureLabel = new JLabel("Select from available creatures below:");
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");
	
	private JButton startButton = new JButton("Start Round"); // creates the start round button
	private JButton endButton = new JButton("End Round"); // creates the end round button
	
	public JButton crabButton = new JButton(); // creates the crab button
	private JButton horseShoeCrabButton = new JButton(); // creates the horseshoe crab
	private JButton extraButton1 = new JButton(); // extra button if needed
	private JButton extraButton2 = new JButton(); // extra button if needed
	private JButton extraButton3 = new JButton(); // extra button if needed
	private JButton extraButton4 = new JButton(); // extra button if needed
	private JButton extraButton5 = new JButton(); // extra button if needed
	private JButton extraButton6 = new JButton(); // extra button if needed
	
	private final JButton GAME_BUTTONS[] = {crabButton, horseShoeCrabButton, extraButton1,
			extraButton2, extraButton3, extraButton4, extraButton5, extraButton6};
	
	private GridLayout creatureLayout = new GridLayout(2,4); // creates the grid for the creature buttons
	private GridLayout enemyLayout = new GridLayout(2,1); // creates the grid for the enemy buttons
	
	
	public static BoardMenuScorePanel scorePanel = 
			new BoardMenuScorePanel(0, 1000, 30, Color.WHITE); // creates new score panel for new game
	public static BoardMenuTimerPanel timerPanel = new BoardMenuTimerPanel(TIME_ON_CLOCK); // creates the timerPanel
	public static BoardMenuCenterPanel cen = new BoardMenuCenterPanel(); // allows access to center panel
	private GameController c1 = new GameController(); // gives access to the controller;
	
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
		
		createButtons(); // creates the set of buttons
		placeImageOnButtonsCreature(GAME_BUTTONS); // places the images onto the buttons	

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
				startButton.setEnabled(false); // disables the button during the rounds
				endButton.setEnabled(true);
				c1.startRound();
				timerPanel.startTimer();
			}
		});
		
		endButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(true); // enables the button after the round is over
				endButton.setEnabled(false); // disables the end round button during no action
				c1.endRound(); // calls commands for ending the game
			}
		});
		
		sidePanel.add(bottomPanel);
	}
	
	// creates the buttons for the game 
	private void createButtons(){
		for(int i = 0; i < GAME_BUTTONS.length; i++){
			middlePanel.add(GAME_BUTTONS[i]);
			
			// disables the buttons that are not needed during the game
			if(i > 2){
				GAME_BUTTONS[i].setEnabled(false);
			}
		}
	}

	// places the images on the JButtons
	private void placeImageOnButtonsCreature(JButton listButtons[]) {
		for(int i = 0; i < GAME_BUTTONS.length && i < listButtons.length; i++){
			GAME_BUTTONS[i].setSize(48, 65);
			Image buttonImage = creatureImg[i].getScaledInstance(GAME_BUTTONS[i].getWidth(),
					GAME_BUTTONS[i].getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(buttonImage);
			
			// gives the blocked out buttons no images and sets text to extra
			if(i <= 2){
				GAME_BUTTONS[i].setIcon(imgIcon);
			}
			else{
				GAME_BUTTONS[i].setText("Extra");
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
