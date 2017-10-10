package BoardMenu;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class BoardMenuView extends JFrame {
	
	final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
	final int WIDTH_OF_SCREEN = SCREEN_SIZE.width; // sets the width of screen from getPreferredSize method
	final int HEIGHT_OF_SCREEN = SCREEN_SIZE.height; // set the height of screen from getPreferredSize method

	// Constructor for TowerDefenseView Class 
	public BoardMenuView(){
		initGUI();
	}
	
	// private method to set graphical interface up 
	private void initGUI(){
		setTitle("Estuary Tower Defense"); // sets the title of the screen
		setSize(WIDTH_OF_SCREEN, HEIGHT_OF_SCREEN); // sets the size of the screen
		setLocationRelativeTo(null); // centers the screen on the display
		setResizable(false); // disables the ability to make the screen bigger or smaller
		setVisible(true); // makes the screen visible
		setDefaultCloseOperation(EXIT_ON_CLOSE); // closes the screen if the user exits from window
	}
	
	// gets the preferred size of the screen that we want to use 
	public Dimension getPreferredSize(){
		Dimension size = new Dimension((int) SCREEN_SIZE.getWidth(),(int) SCREEN_SIZE.getHeight());
		return size;
	}
}
