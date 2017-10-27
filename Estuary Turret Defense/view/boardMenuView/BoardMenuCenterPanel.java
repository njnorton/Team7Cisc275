package boardMenuView;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.turret.turrettypes.TurretCrab;

public class BoardMenuCenterPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	protected JPanel centerPanel = new JPanel();
	
	//Bloons TD 2 TracksEdit. 25 Oct. 2017. Citation for the image used in panel
	private final String centerImage = "images/mediumTrack.png";

	BufferedImage turrcrab;
	private BufferedImage image;

	TurretCrab crab = new TurretCrab();

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

	public void paint(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
