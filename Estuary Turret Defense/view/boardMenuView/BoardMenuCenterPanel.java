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

	private BufferedImage image;

	private BoardMenuSideGamePanel gamePanel = new BoardMenuSideGamePanel();
	private TurretCrab crab = new TurretCrab();
	private GameModel gameMod = new GameModel();
	
	private boolean showGenericBird = false;
	private int showDrawCreature = 0;

	public BoardMenuCenterPanel() {
		try {
			image = ImageIO.read(new File(centerImage));
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
		if(showGenericBird){
		switch(showDrawCreature){
		case 0:
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
			showGenericBird = true;
			showDrawCreature = 0;
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.BIRD_BUTTONS);
			gameMod.purchaseItem(crab);
		}
		if(e.getSource() == BoardMenuSideGamePanel.genericFishButton){
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.FISH_BUTTONS);
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
		if(e.getSource() == BoardMenuSideGamePanel.genericBirdButton){
			BoardMenuSideGamePanel.birdLabel.setLocation(e.getX(), e.getY());
		}
		add(BoardMenuSideGamePanel.birdLabel);
		repaint();
	}
}
