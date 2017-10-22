package boardMenuView;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class BoardMenuCenterPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private JPanel centerPanel = new JPanel();
	private final String centerImage = "images/estuaryTrack.jpg";
	private BufferedImage image;
	
	public BoardMenuCenterPanel(){
		try{
			image = ImageIO.read(new File(centerImage));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		
		addCenterPanel();
	}
	
	public void addCenterPanel(){
		add(centerPanel);
	}
	
	public void paint(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
