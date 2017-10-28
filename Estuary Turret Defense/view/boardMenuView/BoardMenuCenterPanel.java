package boardMenuView;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.GameModel;
import unit.turret.turrettypes.TurretCrab;

public class BoardMenuCenterPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;

	protected JPanel centerPanel = new JPanel();
	
	//Bloons TD 2 TracksEdit. 25 Oct. 2017. Citation for the image used in panel
	private final String centerImage = "images/mediumTrack.png";

	private BufferedImage image;
	
	private BoardMenuSideGamePanel gamePanel = new BoardMenuSideGamePanel();
	private TurretCrab crab = new TurretCrab();
	private GameModel gameMod = new GameModel();
	
	private boolean showGenericBird = false;

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
		}
		
		// draws images onto the screen based upon button clicks 
		if(showGenericBird){
			g.drawImage(gamePanel.creatureImg[0].getScaledInstance(75, 75, Image.SCALE_SMOOTH), 
					crab.getxCor(), crab.getyCor(), null);
		} 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == BoardMenuSideGamePanel.genericBirdButton){
			crab.setCoordinates(50, 200);
			showGenericBird = true;
			BoardMenuSideGamePanel.turnOnButtons(BoardMenuSideGamePanel.BIRD_BUTTONS);
			gameMod.purchaseItem(crab);
		}
		repaint();
	}
}
