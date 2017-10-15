package MainMenu;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class ImagePanelGame extends JPanel{
	
	private static final long serialVersionUID = 1L;

	JPanel centerPanel = new JPanel(); // center panel to place on screen 
	BufferedImage image; // new image to place on screen
	
	final String imageFile = "estuaryPhoto.png";
	
	// Constructor 
	public ImagePanelGame(){
		
		try{
			image = ImageIO.read(new File(imageFile));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	// creates the center panel and adds it to the screen
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
