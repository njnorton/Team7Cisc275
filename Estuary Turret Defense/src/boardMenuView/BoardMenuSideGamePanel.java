package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardMenuSideGamePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel sidePanel = new JPanel(); // creates the side panel for the										// BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel bottomPanel = new JPanel(); // adds the bottom panel to the screen
	private JPanel creaturePanel = new JPanel();
	private JPanel menuPanel = new JPanel();
	
	private JLabel creatureLabel = new JLabel("Select from available creatures below:");
	private JLabel menuInstruction = new JLabel("To begin a new round click Start Round");
	
	BoardMenuScorePanel scorePanel = 
			new BoardMenuScorePanel(0, 1000, 30, Color.WHITE); // creates the scorePanel

	private GridLayout creatureLayout = new GridLayout(2,4); // creates the grid for the creature buttons
	private GridLayout enemyLayout = new GridLayout(2,1); // creates the grid for the enemy buttons

	private final String[] creatureList = { "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png",
			"estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png" };
	private final String[] enemyList = { "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png",
			"estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png", "estuaryPhoto.png" };
	
	private final BufferedImage[] creatureImg = estuaryCreatureButtonImages(creatureList);
	private final BufferedImage[] enemyImg = estuaryEnemyButtonImages(enemyList);

	public BoardMenuSideGamePanel() {
		addScorePanel(); // adds the score panel for the screen
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
	
	private void addLabelMiddleTop(){
		sidePanel.add(creaturePanel);
		creaturePanel.add(creatureLabel);
		creaturePanel.setBackground(Color.LIGHT_GRAY);
		creaturePanel.setPreferredSize(new Dimension(300, 40));
	}

	// adds the middle panel to the screen on BorderLayout East Side
	private void addMiddlePanel() {
		middlePanel.setPreferredSize(new Dimension(300, 450));
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
		
		JButton startButton = new JButton("Start Round");
		JButton endButton = new JButton("End Round");
		bottomPanel.add(startButton);
		bottomPanel.add(endButton);
		
		//placeImageOnButtonsEnemy(); // consider if enemies want to be on buttons 
		
		sidePanel.add(bottomPanel);
	}

	// places the images on the JButtons
	private void placeImageOnButtonsCreature() {
		for (int x = 0; x < creatureList.length; x++) {
			JButton image = new JButton();
			image.setSize(60, 80);
			Image dimg = creatureImg[x].getScaledInstance(image.getWidth(), 
					image.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(dimg);
			image.setIcon(ic);
			middlePanel.add(image);
		}
	}
	
	// places the images on the JButtons
	private void placeImageOnButtonsEnemy() {
		for (int x = 0; x < enemyList.length; x++) {
			JButton image = new JButton();
			image.setSize(55, 40);
			Image dimg = enemyImg[x].getScaledInstance(image.getWidth(), 
					image.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(dimg);
			image.setIcon(ic);
			bottomPanel.add(image);
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

	// creates the button images for the bottom panel
	private BufferedImage[] estuaryEnemyButtonImages(String[] imageList) {
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
