package boardMenu;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class BoardMenuSideGamePanel extends JPanel{

	private static final long serialVersionUID = 1L;
		
	private JPanel sidePanel = new JPanel(); // creates the side panel for the BorderLayout
	private JPanel middlePanel = new JPanel(); // adds the middle panel to the screen
	private JPanel bottomPanel = new JPanel(); // adds the bottom panel to the screen
	
	BoardMenuScorePanel scorePanel = new BoardMenuScorePanel(1000, Color.WHITE); // creates the scorePanel
	
	private GridLayout lay = new GridLayout(2,4); // creates the grid for the buttons 
	
	private final String[] list = {"estuaryPhoto.png","estuaryPhoto.png","estuaryPhoto.png"
			,"estuaryPhoto.png","estuaryPhoto.png","estuaryPhoto.png","estuaryPhoto.png",
			"estuaryPhoto.png"};
	private final BufferedImage[] img = estuaryCreatureButtonImages(list);
	
	public BoardMenuSideGamePanel(){
		addScorePanel(); // adds the score panel for the screen
		addMiddlePanel(); // adds the middle panel for the screen
		addBottomPanel(); // adds the bottom panel for the screen
		sidePanel(); // calls the method to add all components together 
	}
	
	// adds the side panel to the screen on the East Side of BorderLayout
	private void sidePanel(){
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));
		add(sidePanel);
	}
	
	// adds the top panel to the screen with the initial amount of sand dollars 
	private void addScorePanel(){
		sidePanel.add(scorePanel);	
	}
	
	// adds the middle panel to the screen on BorderLayout East Side 
	private void addMiddlePanel(){
		middlePanel.setPreferredSize(new Dimension(300, 350));
		middlePanel.setBackground(Color.LIGHT_GRAY);
		middlePanel.setLayout(lay);
		
		for(int x = 0; x < list.length; x++){
			JButton image = new JButton();
			image.setSize(60, 120);
			Image dimg = img[x].getScaledInstance(image.getWidth(), 
					image.getHeight(), Image.SCALE_SMOOTH);
			ImageIcon ic = new ImageIcon(dimg);
			image.setIcon(ic);
			middlePanel.add(image);
		}
		
		sidePanel.add(middlePanel);
	}
	
	// adds the bottom panel to the screen on BorderLayout East Side 
	private void addBottomPanel(){
		bottomPanel.setPreferredSize(new Dimension(300, 350));
		bottomPanel.setBackground(Color.YELLOW);
		sidePanel.add(bottomPanel);
	}
	
	// creates the buttons images on the middle panel
	private BufferedImage[] estuaryCreatureButtonImages(String[] imageList){
		BufferedImage[] imgList = new BufferedImage[imageList.length];
		try{
			for(int x = 0; x < imageList.length; x++){
			imgList[x] = ImageIO.read(new File(imageList[x]));
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
		return imgList;
	}
	
	// creates the button images for the bottom panel
	private BufferedImage[] estuaryEnemyButtonImages(String[] imageList){
		BufferedImage[] imgList = new BufferedImage[imageList.length];
		return imgList;
	}
}
