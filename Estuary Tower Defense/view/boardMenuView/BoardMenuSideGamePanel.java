package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
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

import gameController.GameController;

//TODO take out end round, the round shouldn't end on a button, it should end when time is up

/*
 * TODO grey out buttons if the player does not have enough money to buy the units
 * TODO trash button to take a unit off the cursor
 * 
 */

/**
 * Creates the entire side panel of the game. Includes the scorepanel, timerpanel, buttonpanels,
 * and the information panel. This is the main control center while the game is running to select 
 * different options. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * List<String> creatureList: the file paths of all of the images for the buttons in the game 
 * BufferedImage[] creatureImg: the images of the creatures used in the game 
 * JPanel sidePanel: the base panel for the side panel in the game 
 * JPanel middlePanel: the base panel that is used for the button panel in the game 
 * JPanel creaturePanel: the button panel that contains all of the buttons used in the game 
 * JLabel creatureLabel: label that gives information about how the select different images 
 * JButton genericBirdButton: the generic bird button that allows for interaction in the game 
 * JButton ospreyButton: the osprey button that allows for interaction in the game 
 * JButton ruddyTurnstoneButton: the ruddy turn stone button that allows for interaction in the game 
 * JButton sanderlingButton: the sanderling button that allows for interaction in the game 
 * JButton genericFishButton: the generic fish button that allows for interaction in the game
 * JButton blueFishButton: the blue fish button that allows for interaction in the game 
 * JButton riverHerringButton: the river herring button that allows for interaction in the game 
 * JButton summerFlounderButton: the summer flounder button that allows for interaction in the game 
 * JButton genericShellfishButton: the generic shellfish button that allows for interaction in the game 
 * JButton blueCrabButton: the blue crab button that allows for interaction in the game 
 * JButton easternOysterButton: the eastern oyster button that allows for interaction in the game 
 * JButton horseShoeCrabButton: the horseshoe crab button that allows for interaction in the game 
 * JButton GAME_BUTTONS[]: the array of all the game buttons that are used in the game 
 * JButton BIRD_BUTTONS[]: the array that contains all of the bird buttons used in the game 
 * JButton FISH_BUTTONS[]: the array that contains all of the fish buttons used in the game 
 * JButton SHELLFISHBUTTONS[]: the array that contains all of the shellfish buttons used in the game 
 * JLabel birdLabel: a bird label for placing an image on the screen
 * GridLayout creatureLayout: the gridlayout for the list of creatures 
 * BoardMenuScorePanel scorePanel: an accessor to the scorepanel in the game 
 * BoardMenuTimerPanel timerPanel: an accessor to the timerpanel in the game 
 * BoardMenuCenterPanel cen: an accessor to the centerpanel in the game 
 * BoardMenuInfoPanel infoPanel: an accessor to the information panel in the game 
 */

public class BoardMenuSideGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	public List<String> creatureList = Arrays.asList(
		"Images/Turrets/Birds/generic_bird.png","Images/Turrets/Birds/osprey.png", 
		"Images/Turrets/Birds/ruddy_turnstone.jpg","Images/Turrets/Birds/sanderling.jpg",
		"Images/Turrets/Fish/generic_fish.png","Images/Turrets/Fish/blue_fish.png", 
		"Images/Turrets/Fish/river_herring.gif", "Images/Turrets/Fish/summer_flounder.gif",
		"Images/Turrets/Shellfish/generic_shellfish.png","Images/Turrets/Shellfish/blue_crab.png", 
		"Images/Turrets/Shellfish/eastern_oyster.jpeg","Images/Turrets/Shellfish/horseshoe_crab.gif");

	// creates the list for the bufferedImages to place on buttons
	protected BufferedImage[] creatureImg = new BufferedImage[creatureList.size()];
	
	private JPanel sidePanel = new JPanel(); // creates the side panel for the BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel creaturePanel = new JPanel(); // adds the panel for describing creature panel
	
	// tells what the available list of creatures are for the game 
	private JLabel creatureLabel = new JLabel("Select from available creatures below:"); 
	
	protected static JButton genericBirdButton = new JButton(); // creates the genericBird button
	protected static JButton ospreyButton = new JButton(); // creates the osprey button
	protected static JButton ruddyTurnstoneButton = new JButton(); // creates the ruddyTurnstone button
	protected static JButton sanderlingButton = new JButton(); // creates the sanderling button
	protected static JButton genericFishButton = new JButton(); // creates the genericFish button
	protected static JButton blueFishButton = new JButton(); // creates the blueFish button
	protected static JButton riverHerringButton = new JButton(); // creates the riverHerring button
	protected static JButton summerFlounderButton = new JButton(); // creates the summerFlounder button
	protected static JButton genericShellfishButton = new JButton(); // creates the genericShellfish button
	protected static JButton blueCrabButton = new JButton(); // creates the blueCrab button
	protected static JButton easternOysterButton = new JButton(); // creates the easternOyster button
	protected static JButton horseShoeCrabButton = new JButton(); // creates the horseShoeCrab button
	
	// a list of all of the gamebuttons that are used in the game
	protected final JButton GAME_BUTTONS[] = {genericBirdButton, ospreyButton, ruddyTurnstoneButton,
			sanderlingButton, genericFishButton, blueFishButton, riverHerringButton, 
			summerFlounderButton, genericShellfishButton, blueCrabButton, 
			easternOysterButton, horseShoeCrabButton};
	
	// these will allow for the turning of on and off of the buttons when not clicked
	// in the beginning of the game
	protected static final JButton BIRD_BUTTONS[] = {ospreyButton, ruddyTurnstoneButton, sanderlingButton};
	protected static final JButton FISH_BUTTONS[] = {blueFishButton, riverHerringButton, summerFlounderButton};
	protected static final JButton SHELLFISHBUTTONS[] = {blueCrabButton, easternOysterButton, horseShoeCrabButton};
	
	protected JLabel birdLabel;
	
	private GridLayout creatureLayout = new GridLayout(3,4); // creates the grid for the creature buttons
	
	public BoardMenuScorePanel scorePanel; // creates new score panel for new game
	public BoardMenuTimerPanel timerPanel; // creates the timerPanel
	public BoardMenuCenterPanel cen; // allows access to center panel
	public BoardMenuInfoPanel infoPanel; // creates the information panel 

	/**
	 * Constructor that sets up the entire board menu side panel. It contains the timer panel,
	 * score panel, information panel, and necessary labels render everything for this panel. 
	 */
	public BoardMenuSideGamePanel() {
		scorePanel = new BoardMenuScorePanel(Color.WHITE);
		timerPanel = new BoardMenuTimerPanel();
		cen = new BoardMenuCenterPanel();
		infoPanel = new BoardMenuInfoPanel();
		
		//sets up everything
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		setBackground(Color.BLACK); // sets the color of the background for the screen
		sidePanel.add(scorePanel); // adds the score panel to the screen on East Side
		sidePanel.add(timerPanel); // adds the timer panel to the screen on East Side
		addLabelMiddleTop(); // adds a label to identify creature section
		addMiddlePanel(); // adds the middle panel for the screen
		sidePanel.add(infoPanel); // adds the information panel to the screen
		
		add(sidePanel);
	}
	/**
	 * Adds the label that gives information about how to select creatures from the 
	 * button panel in the game. Is necessary for user interaction so they know what to 
	 * do when they start to play the game. 
	 */
	private void addLabelMiddleTop(){
		sidePanel.add(creaturePanel);
		creaturePanel.add(creatureLabel);
		creaturePanel.setBackground(Color.YELLOW);
		creaturePanel.setPreferredSize(new Dimension(260, 25));
	}

	/**
	 * adds the button panel to the side panel of the game. There are 12 total buttons that 
	 * are added to the panel using a method call. This is where all of the interaction takes 
	 * place to add creatures to the centerpanel as necessary throughout the game. 
	 */
	private void addMiddlePanel() {
		middlePanel.setPreferredSize(new Dimension(260, 260));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(creatureLayout);
		
		createButtons(); // creates the set of buttons from next method below 
		placeImageOnButtonsCreature(GAME_BUTTONS); // places the images onto the buttons	
		birdLabel = new JLabel(new ImageIcon(creatureImg[0].getScaledInstance
				(75, 75, Image.SCALE_SMOOTH)));
		sidePanel.add(middlePanel);
	}
	
	/**
	 * Creates the buttons that are added to the centerpanel in the game side panel. 
	 * It also turns off the last three buttons in every row for a game restriction 
	 * that the first image must be purchased before the upgrades are able to be used 
	 * in the game.  
	 */
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

	/**
	 * Adds images to the buttons that are used in the game. It takes in an array of buttons 
	 * and cycles through them and adds the appropriate image to them. If there is not an equal
	 * amount of buttons and images, then this method will not run and will throw and error to 
	 * the user. 
	 * 
	 * @param listButtons the array of buttons that will get images added to the buttons 
	 */
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

	/**
	 * Reads in each of the images contained in the creatureImg array and 
	 * puts them into a buffered image array to use for other functions of the 
	 * game. Will throw an IOException if one of the images is not able to be read. 
	 */
	private void estuaryCreatureButtonImages() {
		try {
			for (int x = 0; x < creatureList.size(); x++) {
				creatureImg[x] = ImageIO.read(new File(creatureList.get(x)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Takes in a list of JButtons that are able to be turned on when a user 
	 * clicks on the first button and places it on the screen. There also has to 
	 * be enough money left for the user to enable these buttons and if not they stay off. 
	 * 
	 * @param input an array of JButtons that are used in the game 
	 */
	public static void turnOnButtons(JButton input[]){
		for(JButton buttons: input){
			if(GameController.model.player.getMoney() < GameController.model.player.getMoney()){
				buttons.setEnabled(false);
			}
			else{
				buttons.setEnabled(true);
			}
		}
	}
}
