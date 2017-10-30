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

import game.GameModel;
import unit.turret.turrettypes.TurretCrab;

public class BoardMenuCenterPanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener{

	private static final long serialVersionUID = 1L;

	protected JPanel centerPanel = new JPanel();
	
	//Bloons TD 2 TracksEdit. 25 Oct. 2017. Citation for the image used in panel
	private final String centerImage = "images/mediumTrack.png";
	private final String birdImage = "Images/Turrets/Birds/generic_bird.png";

	private BufferedImage image;
	public BufferedImage birdImg;
	protected static JLabel birdLabel; 
	
	private static BoardMenuSideGamePanel gamePanel = new BoardMenuSideGamePanel();
	private TurretCrab crab = new TurretCrab();
	private GameModel gameMod = new GameModel();
	
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
		for(int i = 0; i < gamePanel.GAME_BUTTONS.length; i++){
			gamePanel.GAME_BUTTONS[i].addActionListener(this);
			gamePanel.GAME_BUTTONS[i].addMouseListener(this);
			gamePanel.GAME_BUTTONS[i].addMouseMotionListener(this);
		}
		
		// draws images onto the screen based upon button clicks
		if(showCreature){
		switch(showDrawCreature){
		case 0:
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH), 
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 1: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 2: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 3: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 4:
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 5: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 6: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 7: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 8:
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 9: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 10: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		case 11: 
			g.drawImage(gamePanel.creatureImg[showDrawCreature].getScaledInstance(75, 75, Image.SCALE_SMOOTH),
					crab.getxCor(), crab.getyCor(), null);
			break;
		}
		}
		/*if(showGenericBird){
			g.drawImage(gamePanel.creatureImg[0].getScaledInstance(75, 75, Image.SCALE_SMOOTH), 
					crab.getxCor(), crab.getyCor(), null);
		} */
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == BoardMenuSideGamePanel.genericBirdButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 0;
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.BIRD_BUTTONS);
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.ospreyButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 1;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.ruddyTurnstoneButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 2;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.sanderlingButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 3;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.genericFishButton){
			showCreature = true;
			showDrawCreature = 4;
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.FISH_BUTTONS);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.blueFishButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 5;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.blueFishButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 6;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.summerFlounderButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 7;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.genericShellfishButton){
			showCreature = true;
			showDrawCreature = 8;
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.SHELLFISHBUTTONS);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.blueCrabButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 9;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.easternOysterButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 10;
			gameMod.purchaseItem(crab);
		}
		else if(e.getSource() == BoardMenuSideGamePanel.horseShoeCrabButton){
			//crab.setCoordinates(50, 200);
			showCreature = true;
			showDrawCreature = 11;
			gameMod.purchaseItem(crab);
		}
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
		if(e.getSource().equals(BoardMenuSideGamePanel.genericBirdButton)){
            birdLabel.setLocation(e.getX(), e.getY());
			add(birdLabel);
		}
		
		repaint();
	}
}
