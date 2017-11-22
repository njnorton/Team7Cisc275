package leaderBoardView;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameController.GameController;

public class LeaderBoardCenterPanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> leaders = new ArrayList<>();
	private ArrayList<String> outputLeaders = new ArrayList<>();
	private final String LEADERS_FILE_IN = "leaders.txt";
	
	
	private JPanel centerPanel = new JPanel();

	public LeaderBoardCenterPanel(){
		setBackground(Color.LIGHT_GRAY);
		centerPanel.setBackground(Color.WHITE);
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setPreferredSize(new Dimension(550,300));
		
		// For Testing Purposes Only!
		JLabel testLabel = new JLabel();
		JLabel titleLabel = new JLabel();
		
		String testTitle = String.format("%20s%28s%50s", "Name", "Score", "Date"); // Stay for format! DO NOT DELETE
		
		titleLabel.setText("" + testTitle);
		
		centerPanel.add(titleLabel);
		centerPanel.add(testLabel);
		
		readLeaderBoardFile();
		
		add(centerPanel);
	}
	
	public void readLeaderBoardFile(){
		int index = 0;
		try{
			BufferedReader in = new BufferedReader(new FileReader(LEADERS_FILE_IN));
			String record = in.readLine();
			
			while(record != null){
				outputLeaders.add(record);
				int indexBlank = record.indexOf(" ");
				String scoreList = record.substring(0, indexBlank);
				int oldScoreList = Integer.parseInt(scoreList);
				if(oldScoreList > 0){
					index++;
				}
				record = in.readLine();
			}
			in.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		if(index < 11){
			String name = JOptionPane.showInputDialog(this, "Enter Your Name");
			int score = 100;
			Date date = new Date();
			String addRecord = String.format("%-35s%-29d%-25s", name, score, date); // Stays for format! DO NOT DELETE
			String addRecord2 = String.format("%-35d%-29s%-25s", score, name, date); // Stays for format! DO NOT DELETE
			outputLeaders.add(index, addRecord2);
			
			for(int x = 0; x < outputLeaders.size(); x++){
				JLabel newRecord = new JLabel();
				newRecord.setText("" + outputLeaders.get(x));
				centerPanel.add(newRecord);
			}
			
			if(outputLeaders.size() > 11){
				outputLeaders.remove(11);
			}
			saveLeaderBoard(outputLeaders);
		}
	}
	
	private void saveLeaderBoard(ArrayList<String> leaderList){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter(LEADERS_FILE_IN));
			
			for(int x = 0; x < leaderList.size(); x++){
				out.write(leaderList.get(x));
				out.newLine();
			}
			
			out.close();
		}
		catch(Exception e){
			
		}
	}
}
