package MainMenu;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class TitlePanel extends JLabel{

	private static final long serialVersionUID = 1L;

	public TitlePanel(String titleText){
		Font titleFont = new Font(Font.DIALOG, Font.BOLD, 32);
		setFont(titleFont);
		setBackground(Color.YELLOW);
		setForeground(Color.RED);
		setOpaque(true);
		setHorizontalAlignment(JLabel.CENTER);
		setText(titleText);
	}
}
