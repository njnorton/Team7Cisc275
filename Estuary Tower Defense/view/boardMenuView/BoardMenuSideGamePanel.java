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

//TODO take out end round, the round shouldn't end on a button, it should end when time is up

/*
 * TODO grey out buttons if the player does not have enough money to buy the units
 * TODO trash button to take a unit off the cursor
 */
public class BoardMenuSideGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	List<String> creatureList = Arrays.asList(
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
	
	protected JButton startButton = new JButton("Start Round"); // creates the start round button
	protected JButton endButton = new JButton("End Round"); // creates the end round button
	
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
	public BoardMenuInfoPanel infoPanel;

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
	
	private void addLabelMiddleTop(){
		sidePanel.add(creaturePanel);
		creaturePanel.add(creatureLabel);
		creaturePanel.setBackground(Color.YELLOW);
		creaturePanel.setPreferredSize(new Dimension(260, 25));
	}

	// adds the middle panel to the screen on BorderLayout East Side
	private void addMiddlePanel() {
		middlePanel.setPreferredSize(new Dimension(260, 260));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(creatureLayout);
		
		createButtons(); // creates the set of buttons
		placeImageOnButtonsCreature(GAME_BUTTONS); // places the images onto the buttons	
		birdLabel = new JLabel(new ImageIcon(creatureImg[0].getScaledInstance
				(75, 75, Image.SCALE_SMOOTH)));
		sidePanel.add(middlePanel);
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
		try {
			for (int x = 0; x < creatureList.size(); x++) {
				creatureImg[x] = ImageIO.read(new File(creatureList.get(x)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void turnOnButtons(JButton input[]){
		for(JButton buttons: input){
			buttons.setEnabled(true);
		}
	}
}
