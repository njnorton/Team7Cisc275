package mainMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;

public class TitlePanel extends JLabel{

	private static final long serialVersionUID = 1L;

	// Constructor to make the title panel across the top of the screen
	public TitlePanel(String titleText){
		Font titleFont = new Font(Font.DIALOG, Font.BOLD, 32); // creates the font
		setFont(titleFont); // sets the font
		setBackground(Color.YELLOW); // sets the background color
		setForeground(Color.RED); // sets the color of the letters in writing
		setOpaque(true); // allows the colors to sit on top of each other
		setHorizontalAlignment(JLabel.CENTER); // aligns to the center of the screen
		setText(titleText); // sets the text for the tile based on given constructor input
	}
	
	// sets the preferred size of the JPanel
	public Dimension getPreferredSize(){
		Dimension size = new Dimension(0, 47);
		return size;
	}
}
