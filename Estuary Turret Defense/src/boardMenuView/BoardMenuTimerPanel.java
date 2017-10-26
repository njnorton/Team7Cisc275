package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import player.PlayerModel;

public class BoardMenuTimerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private long time = 0; // the time that is passed in 
	private long remainingTime = 0; // current state of the clock
	private String timeString = "00:00"; // the time string representation of the countdown
		
	private Font timerFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font 

	Thread timerThread; // the thread that the timer is run on 

	// constructor 
	public BoardMenuTimerPanel(long time) {
		this.time = time;
		remainingTime = time;
		
		setPreferredSize(new Dimension(300, 45));
		setFont(timerFont);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1,2));
		setTime(time); // sets the time for the game
		
		// adds the JLabel to the screen 
		JLabel timer = new JLabel("Time Remaining: ");
		timer.setFont(timerFont);
		add(timer);	
	}

	// sets the time into minutes and seconds 
	private void setTime(long time) {
		this.time = time;
		long minutes = (time / 60) % 60;
		long seconds = time % 60;
		timeString = String.format("%02d:%02d", minutes, seconds);
		repaint(); // updates the panel for the timer
	}

	// starts the timer 
	public void startTimer() {
		stopTimer();
		timerThread = new Thread(this);
		timerThread.start();
	}

	// stops the timer 
	public void stopTimer() {
		if(timerThread != null){
			timerThread.interrupt();
			timerThread = null;
		}
	}
	
	// rests the clock to given time 
	public void reset(){
		setTime(remainingTime);
	}
	
	// paints the graphics onto the screen
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(timeString, 150, 30);
		repaint();
	}

	// what to do on tick for the runnable
	@Override
	public void run() {
		while(time > 0){
			time -= 1;
			setTime(time);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}
		timesUp();
	}
	
	// Options allows you to start the game again if you so choose.
	public void timesUp(){
		int value = JOptionPane.showConfirmDialog(null, "Time is up! Do you want to play again?", 
				"Play Again?", JOptionPane.YES_NO_OPTION);
		
		switch(value){
		case 0:
			PlayerModel model = new PlayerModel();
			model.resetPanel(); // resets the score panel back to original values 
			break;
		case 1:
			System.exit(0); // terminates the game 
			break;
		}
		
	}
}
