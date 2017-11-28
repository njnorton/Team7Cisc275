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
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameController.GameController;
import unit.TowerModel;
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

public class BoardMenuCenterPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener {

	private static final long serialVersionUID = 1L;

	public JPanel centerPanel = new JPanel();

	// Bloons TD 2 TracksEdit. 25 Oct. 2017. Citation for the image used in
	// panel
	private final String centerImage = "images/mediumTrack.png";
	private final String birdImage = "Images/Turrets/Birds/generic_bird.png";

	private static BufferedImage image;
	public BufferedImage birdImg;
	protected static JLabel birdLabel;

	private boolean showCreature = false;
	private int showDrawCreature = 0;

	public BoardMenuCenterPanel() {
		try {
			image = ImageIO.read(new File(centerImage));
			birdImg = ImageIO.read(new File(birdImage));
			birdLabel = new JLabel(new ImageIcon(birdImg.getScaledInstance(75, 75, Image.SCALE_SMOOTH)));
		} catch (IOException e) {
			e.printStackTrace();
		}
		add(centerPanel);
	}

	public void paintComponent(Graphics g) {

		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		//addMouseListener(this);

		// gives all the game buttons for species action listeners
		for (int i = 0; i < GameController.view.boardMenu.sidePanel.GAME_BUTTONS.length; i++) {
			GameController.view.boardMenu.sidePanel.GAME_BUTTONS[i].addActionListener(this);
			GameController.view.boardMenu.sidePanel.GAME_BUTTONS[i].addMouseMotionListener(this);
		}

		for(TowerModel tm1 : GameController.model.towerList) {
			String towerName = tm1.getName();
			BufferedImage towerImg = null;
			switch(towerName) {
			case "GenericBird":
				try {
					towerImg = ImageIO.read(new File(GameController.view.boardMenu.sidePanel.creatureList.get(0)));
				} catch (IOException e) {
					e.printStackTrace();
				}
				g.drawImage(towerImg, tm1.getxCor(), tm1.getyCor(), null);
			}
		}
		/*
		// draws images onto the screen based upon button clicks
		if (showCreature) {
			// TODO update the index values
			switch (showDrawCreature) {
			case 0:
				g.drawImage(
						GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75,
								Image.SCALE_SMOOTH),
						GameController.model.towerModelList.get(0).getxCor(),
						GameController.model.towerModelList.get(0).getyCor(), null);
				break;
			case 4:
				g.drawImage(
						GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75,
								Image.SCALE_SMOOTH),
						GameController.model.towerModelList.get(1).getxCor(),
						GameController.model.towerModelList.get(1).getyCor(), null);
				break;
			case 8:
				g.drawImage(
						GameController.view.boardMenu.sidePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75,
								Image.SCALE_SMOOTH),
						GameController.model.towerModelList.get(2).getxCor(),
						GameController.model.towerModelList.get(2).getyCor(), null);
				break;
			}
		}
		
		 * if(showGenericBird){
		 * g.drawImage(gamePanel.creatureImg[0].getScaledInstance(75, 75,
		 * Image.SCALE_SMOOTH), crab.getxCor(), crab.getyCor(), null); }
		 */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == GameController.view.boardMenu.sidePanel.genericBirdButton) {

			// showCreature = true;
			// showDrawCreature = 0;

			GameController.view.boardMenu.sidePanel.infoPanel
					.setCreatureText(GameController.model.towerModelList.get(0).getName());
			GameController.view.boardMenu.sidePanel.infoPanel
					.setFactText(GameController.model.towerModelList.get(0).getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel
					.setCost(GameController.model.towerModelList.get(0).getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel
					.setDamage(GameController.model.towerModelList.get(0).getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel
					.setRange(GameController.model.towerModelList.get(0).getRange());

			TowerModel tm1 = GameController.model.factory.makeTower("Generic Bird");

			int xCor = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Please enter an x-coordinate for the tower placement or click cancel."));
			int yCor = Integer.parseInt(
					JOptionPane.showInputDialog(null, "Please enter a y-coordinate for the tower placement or click cancel."));
			tm1.setxCor(xCor);
			tm1.setyCor(yCor);
			GameController.model.towerList.add(tm1);
		}
		/*
		 * else if(e.getSource() == BoardMenuSideGamePanel.ospreyButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 1; } else if(e.getSource() ==
		 * BoardMenuSideGamePanel.ruddyTurnstoneButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 2; } else if(e.getSource() ==
		 * BoardMenuSideGamePanel.sanderlingButton){ //crab.setCoordinates(50,
		 * 200); showCreature = true; showDrawCreature = 3; }
		 */
		else if (e.getSource() == GameController.view.boardMenu.sidePanel.genericFishButton) {
			showCreature = true;
			showDrawCreature = 4;

			TowerModel t1 = GameController.model.factory.makeTower("Generic Fish");

			GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(t1.getName());
			GameController.view.boardMenu.sidePanel.infoPanel.setFactText(t1.getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel.setCost(t1.getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel.setDamage(t1.getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel.setRange(t1.getRange());
		}
		/*
		 * else if(e.getSource() == BoardMenuSideGamePanel.blueFishButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 5; } else if(e.getSource() ==
		 * BoardMenuSideGamePanel.blueFishButton){ //crab.setCoordinates(50,
		 * 200); showCreature = true; showDrawCreature = 6; } else
		 * if(e.getSource() == BoardMenuSideGamePanel.summerFlounderButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 7; }
		 */
		else if (e.getSource() == GameController.view.boardMenu.sidePanel.genericShellfishButton) {
			showCreature = true;
			showDrawCreature = 8;

			TowerModel t1 = GameController.model.factory.makeTower("Generic Shellfish");

			GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(t1.getName());
			GameController.view.boardMenu.sidePanel.infoPanel.setFactText(t1.getFactDescription());
			GameController.view.boardMenu.sidePanel.infoPanel.setCost(t1.getPrice());
			GameController.view.boardMenu.sidePanel.infoPanel.setDamage(t1.getDamage());
			GameController.view.boardMenu.sidePanel.infoPanel.setRange(t1.getRange());
		}

		/*
		 * else if(e.getSource() == blueCrabButton){ //crab.setCoordinates(50,
		 * 200); showCreature = true; showDrawCreature = 9;
		 * 
		 * TowerModel t1 = GameController.model.factory.makeTower("Blue Crab");
		 * 
		 * GameController.view.boardMenu.sidePanel.infoPanel.setCreatureText(t1.
		 * getName());
		 * GameController.view.boardMenu.sidePanel.infoPanel.setFactText(t1.
		 * getFactDescription());
		 * GameController.view.boardMenu.sidePanel.infoPanel.setCost(t1.getPrice
		 * ()); GameController.view.boardMenu.sidePanel.infoPanel.setDamage(t1.
		 * getDamage());
		 * GameController.view.boardMenu.sidePanel.infoPanel.setRange(t1.
		 * getRange()); }
		 * 
		 * else if(e.getSource() == BoardMenuSideGamePanel.easternOysterButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 10; } else if(e.getSource() ==
		 * BoardMenuSideGamePanel.horseShoeCrabButton){
		 * //crab.setCoordinates(50, 200); showCreature = true; showDrawCreature
		 * = 11; }
		 */
		repaint();
	}

	// redraw every enemy
	public static void draw() {

	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		/*
		if (e.getSource().equals(GameController.view.boardMenu.sidePanel.genericBirdButton)) {
			birdLabel.setLocation(e.getX(), e.getY());
			add(birdLabel);
		}

		repaint();
		*/
	}
}
