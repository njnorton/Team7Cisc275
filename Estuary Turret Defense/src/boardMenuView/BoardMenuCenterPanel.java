package boardMenuView;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import unit.turret.turrettypes.TurretCrab;

public class BoardMenuCenterPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	protected JPanel centerPanel = new JPanel();
	private final String centerImage = "images/estuaryTrack.jpg";
	BufferedImage turrcrab;
	private BufferedImage image;

	BoardMenuSideGamePanel gamePanel = new BoardMenuSideGamePanel();
	TurretCrab crab = new TurretCrab();

	public BoardMenuCenterPanel() {
		try {
			image = ImageIO.read(new File(centerImage));
			turrcrab = ImageIO.read(new File("images/crab1.png"));
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
		gamePanel.crabButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
		
			}
		});
	}
}
