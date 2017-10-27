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
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import game.GameModel;

public class BoardMenuSideGamePanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private final static int TIME_ON_CLOCK = 45; // how much time is on the clock for the game
	
	List<String> creatureList = Arrays.asList(
		"Images/Turrets/Birds/generic_bird.png","Images/Turrets/Birds/osprey.png", 
		"Images/Turrets/Birds/ruddy_turnstone.jpg","Images/Turrets/Birds/sanderling.jpg",
		"Images/Turrets/Fish/generic_fish.png","Images/Turrets/Fish/blue_fish.png", 
		"Images/Turrets/Fish/river_herring.gif", "Images/Turrets/Fish/summer_flounder.gif",
		"Images/Turrets/Shellfish/generic_shellfish.png","Images/Turrets/Shellfish/blue_crab.png", 
		"Images/Turrets/Shellfish/eastern_oyster.jpeg","Images/Turrets/Shellfish/horseshoe_crab.gif");

	// creates the list for the bufferedImages to place on buttons
	private BufferedImage[] creatureImg;

	private JPanel sidePanel = new JPanel(); // creates the side panel for the BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel bottomPanel = new JPanel(); // adds the bottom panel to the screen
	private JPanel creaturePanel = new JPanel(); // adds the panel for describing creature panel
	private JPanel menuPanel = new JPanel(); // adds the panel for describing the selection of game play
	
	// tells what the available list of creatures are for the game 
	private JLabel creatureLabel = new JLabel("Select from available creatures below:"); 
	// gives instruction on how the rounds work to play the game 
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");
	
	private JButton startButton = new JButton("Start Round"); // creates the start round button
	private JButton endButton = new JButton("End Round"); // creates the end round button
	
	private JButton genericBirdButton = new JButton(); // creates the genericBird button
	private JButton ospreyButton = new JButton(); // creates the osprey button
	private JButton ruddyTurnstoneButton = new JButton(); // creates the ruddyTurnstone button
	private JButton sanderlingButton = new JButton(); // creates the sanderling button
	private JButton genericFishButton = new JButton(); // creates the genericFish button
	private JButton blueFishButton = new JButton(); // creates the blueFish button
	private JButton riverHerringButton = new JButton(); // creates the riverHerring button
	private JButton summerFlounderButton = new JButton(); // creates the summerFlounder button
	private JButton genericShellfishButton = new JButton(); // creates the genericShellfish button
	private JButton blueCrabButton = new JButton(); // creates the blueCrab button
	private JButton easternOysterButton = new JButton(); // creates the easternOyster button
	private JButton horseShoeCrabButton = new JButton(); // creates the horseShoeCrab button
	
	// a list of all of the gamebuttons that are used in the game
	private final JButton GAME_BUTTONS[] = {genericBirdButton, ospreyButton, ruddyTurnstoneButton,
			sanderlingButton, genericFishButton, blueFishButton, riverHerringButton, 
			summerFlounderButton, genericShellfishButton, blueCrabButton, 
			easternOysterButton, horseShoeCrabButton};
	
	// these will allow for the turning of on and off of the buttons when not clicked
	// in the beginning of the game
	public final JButton BIRD_BUTTONS[] = {ospreyButton, ruddyTurnstoneButton, sanderlingButton};
	protected final JButton FISH_BUTTONS[] = {blueFishButton, riverHerringButton, summerFlounderButton};
	protected final JButton SHELLFISHBUTTONS[] = {blueCrabButton, easternOysterButton, horseShoeCrabButton};
	
	private GridLayout creatureLayout = new GridLayout(3,4); // creates the grid for the creature buttons
	private GridLayout buttonLayout = new GridLayout(2,1); // creates the grid for the enemy buttons
	
	public static BoardMenuScorePanel scorePanel = 
			new BoardMenuScorePanel(0, 1000, 30, Color.WHITE); // creates new score panel for new game
	public static BoardMenuTimerPanel timerPanel = new BoardMenuTimerPanel(TIME_ON_CLOCK); // creates the timerPanel
	public static BoardMenuCenterPanel cen = new BoardMenuCenterPanel(); // allows access to center panel
	private GameModel c1 = new GameModel(); // gives access to the controller;
	
	public BoardMenuSideGamePanel() {
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		setBackground(Color.BLACK); // sets the color of the background for the screen
		sidePanel.add(scorePanel); // adds the score panel to the screen on East Side
		sidePanel.add(timerPanel); // adds the timer panel to the screen on East Side
		addLabelMiddleTop(); // adds a label to identify creature section
		addMiddlePanel(); // adds the middle panel for the screen
		addBottomLabel(); // adds a label to identify menu selection
		addBottomPanel(); // adds the bottom panel for the screen
		
		add(sidePanel);
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

		genericBirdButton.addActionListener(this);
		genericFishButton.addActionListener(this);
		genericShellfishButton.addActionListener(this);
		
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
		bottomPanel.setLayout(buttonLayout);
		
		bottomPanel.add(startButton);
		bottomPanel.add(endButton);
	
		// adds action listener on the button click for the game
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				startButton.setEnabled(false); // disables the button during the rounds
				endButton.setEnabled(true); // enables the button during the rounds
				c1.startRound(); // starts the wave 
				timerPanel.startTimer(); // starts the time event for game play	
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
		}
		// turns off the bird buttons
		for(JButton turnoff: BIRD_BUTTONS){
			turnoff.setEnabled(false);
		}
		// turns off the fish buttons
		for(JButton turnoff: FISH_BUTTONS){
			turnoff.setEnabled(false);
		}
		// turns off the shellfish buttons
		for(JButton turnoff: SHELLFISHBUTTONS){
			turnoff.setEnabled(false);
		}
		
	}

	// places the images on the JButtons
	private void placeImageOnButtonsCreature(JButton listButtons[]) {
		estuaryCreatureButtonImages(); // calls the image to initialize the pictures
		for(int i = 0; i < GAME_BUTTONS.length && i < listButtons.length; i++){
			GAME_BUTTONS[i].setSize(48, 65);
			Image buttonImage = creatureImg[i].getScaledInstance(GAME_BUTTONS[i].getWidth(),
					GAME_BUTTONS[i].getHeight(), Image.SCALE_SMOOTH);
			ImageIcon imgIcon = new ImageIcon(buttonImage);
			GAME_BUTTONS[i].setIcon(imgIcon);	
		}
	}

	// creates the buttons images on the middle panel
	private void estuaryCreatureButtonImages() {
		 creatureImg = new BufferedImage[creatureList.size()];
		try {
			for (int x = 0; x < creatureList.size(); x++) {
				creatureImg[x] = ImageIO.read(new File(creatureList.get(x)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void turnOnButtons(JButton input[]){
		for(JButton buttons: input){
			buttons.setEnabled(true);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == genericBirdButton){
			turnOnButtons(BIRD_BUTTONS);
		} else if(e.getSource() == genericFishButton){
			turnOnButtons(FISH_BUTTONS);
		} else if(e.getSource() == genericShellfishButton){
			turnOnButtons(SHELLFISHBUTTONS);
		}
	}	
}
