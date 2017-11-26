package boardMenuView;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameController.GameController;
import unit.towerTypes.*;

/*
 * When the player clicks on a unit on the side panel, it should track the mouse movement on the center panel,
 * and change the cursor to the icon of the selected unit (ideally it'll also display a little translucent circle
 * indicating the target's attack range and if it can be placed in the selected area (maybe a red/grey circle if
 * it can't be placed there (do this with a boolean))). 
 * 
 * On a click with the selected unit cursor, it should place
 * the unit on the board and tell the controller to add the tower to the tower ArrayList. On a click on the trash 
 * can on the side panel, it should revert the cursor back to the regular cursor. 
 * 
 * On Start Round, it should take the enemies generated from the enemyArrayList and paint their corresponding 
 * locations on the map.
 * 
 * On removal of an enemy from the enemy ArrayList, it should play that enemy's death animation.
 * 
 * On tower fire, it should play that tower's fire animation.
 */

public class BoardMenuCenterPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	public static JPanel centerPanel = new JPanel();
	
	//Bloons TD 2 TracksEdit. 25 Oct. 2017. Citation for the image used in panel
	private final String centerImage = "images/mediumTrack.png";
	private final String birdImage = "Images/Turrets/Birds/generic_bird.png";

	private static BufferedImage image;
	public BufferedImage birdImg;
	protected static JLabel birdLabel; 
	
	
	private TowerBlueCrab crab = new TowerBlueCrab();
	
	private boolean showCreature = false;
	private int showDrawCreature = 0;

	public BoardMenuCenterPanel() {
		try {
			image = ImageIO.read(new File(centerImage));
			birdImg = ImageIO.read(new File(birdImage));
			birdLabel = new JLabel(new ImageIcon
					(birdImg.getScaledInstance
					(75, 75, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		addCenterPanel();
	}

	public void addCenterPanel() {
		add(centerPanel);
	}

	
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		
		// gives all the game buttons for species action listeners 
		for(int i = 0; i < GameController.view.boardMenu.sidePanel.GAME_BUTTONS.length; i++){
			GameController.view.boardMenu.sidePanel.GAME_BUTTONS[i].addActionListener(this);
			GameController.view.boardMenu.sidePanel.GAME_BUTTONS[i].addMouseListener(this);
			GameController.view.boardMenu.sidePanel.GAME_BUTTONS[i].addMouseMotionListener(this);
		}
		
		// draws images onto the screen based upon button clicks
		if(showCreature){
		switch(showDrawCreature){
		case 0:
			g.drawImage(GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH), 
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 4:
			g.drawImage(GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 8:
			g.drawImage(GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		}
	}
		/*if(showGenericBird){
			g.drawImage(gamePanel.creatureImg[0].getScaledInstance(75, 75, Image.SCALE_SMOOTH), 
					crab.getxCor(), crab.getyCor(), null);
		} */
	}
	
	//redraw every enemy 
	public static void draw(){
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == GameController.view.boardMenu.sidePanel.genericBirdButton){
			showCreature = true;
			showDrawCreature = 0;
			GameController.view.boardMenu.sidePanel.turnOnButtons(
					GameController.view.boardMenu.sidePanel.BIRD_BUTTONS);
			
			GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(GameController.model.genericBird.getName());
			GameController.view.boardMenu.sidePanel.infoPanel.setFactText(GameController.model.genericBird.getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel.setCost(GameController.model.genericBird.getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel.setDamage(GameController.model.genericBird.getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel.setRange(GameController.model.genericBird.getRange());
		}
		/*else if(e.getSource() == BoardMenuSideGamePanel.ospreyButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 1;
		}
		else if(e.getSource() == BoardMenuSideGamePanel.ruddyTurnstoneButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 2;
		}
		else if(e.getSource() == BoardMenuSideGamePanel.sanderlingButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 3;
		}*/
		else if(e.getSource() == GameController.view.boardMenu.sidePanel.genericFishButton){
			showCreature = true;
			showDrawCreature = 4;
			GameController.view.boardMenu.sidePanel.turnOnButtons(
					GameController.view.boardMenu.sidePanel.FISH_BUTTONS);
			
			GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(GameController.model.genericFish.getName());
			GameController.view.boardMenu.sidePanel.infoPanel.setFactText(GameController.model.genericFish.getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel.setCost(GameController.model.genericFish.getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel.setDamage(GameController.model.genericFish.getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel.setRange(GameController.model.genericFish.getRange());
		}
		/*else if(e.getSource() == BoardMenuSideGamePanel.blueFishButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 5;
		}
		else if(e.getSource() == BoardMenuSideGamePanel.blueFishButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 6;
		}
		else if(e.getSource() == BoardMenuSideGamePanel.summerFlounderButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 7;
		}
		*/
		else if(e.getSource() == GameController.view.boardMenu.sidePanel.genericShellfishButton){
			showCreature = true;
			showDrawCreature = 8;
			GameController.view.boardMenu.sidePanel.turnOnButtons(
					GameController.view.boardMenu.sidePanel.SHELLFISHBUTTONS);
		}
		
		else if(e.getSource() == BoardMenuSideGamePanel.blueCrabButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 9;
			
			GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(GameController.model.blueCrab.getName());
			GameController.view.boardMenu.sidePanel.infoPanel.setFactText(GameController.model.blueCrab.getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel.setCost(GameController.model.blueCrab.getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel.setDamage(GameController.model.blueCrab.getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel.setRange(GameController.model.blueCrab.getRange());
		}
		/*
		else if(e.getSource() == BoardMenuSideGamePanel.easternOysterButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 10;
		}
		else if(e.getSource() == BoardMenuSideGamePanel.horseShoeCrabButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 11;
		}*/
		repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {	
		crab.setCoordinates(e.getX(), e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {	
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		if(e.getSource().equals(GameController.view.boardMenu.sidePanel.genericBirdButton)){
            birdLabel.setLocation(e.getX(), e.getY());
			add(birdLabel);
		}
		
		repaint();
	}
}
