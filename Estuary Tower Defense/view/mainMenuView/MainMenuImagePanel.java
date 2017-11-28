package mainMenuView;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Creates the centerPanel for the main menu with an image. 
 * 
 * @author  Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * JPanel centerPanel: the base for the image to sit on for the centerPanel on JFrame.
 * BufferedImage image: the image that will be used to be placed on the center of the panel
 * String imageFile: the String representation of the image file path to load into the panel
 * 
 */

public class MainMenuImagePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	JPanel centerPanel = new JPanel(); // center panel to place on screen 
	BufferedImage image; // new image to place on screen
	
	final String imageFile = "images/estuaryPhoto.png";
	
	/**
	 * Constructor for the class. It loads in the selected image from the file given
	 * and sets it to the BufferedImage created.  
	 */
	public MainMenuImagePanel(){
		
		try{
			image = ImageIO.read(new File(imageFile));
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
	
	/**
	 * Draws onto the panel the given image that was loaded to the full size of the panel. 
	 * It accomplishes this through the use of the Graphics class drawImage function.
	 */
	public void paintComponent(Graphics g){
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}
}
