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

	// Take three listed below out at Beta 
	private long time = 0; // the time that is passed in 
	private long remainingTime = 0; // current state of the clock
	private String timeString = "00:00"; // the time string representation of the countdown
		
	private Font timerFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font 

	private final int WIDTH = 150; // not until Beta but for graphic timer 
	private final int HEIGHT = 20; // not until Beta but for graphic timer
	private final int X = 140; // not until Beta but for graphic timer
	private final int Y = 13; // not until Beta but for graphic timer 
	
	private int currentWidth = WIDTH; // not until Beta but for graphic timer
	private long timerBar = 0; // not until Beta but for graphic timer 
	private double currentTimeBar = 0; // not until Beta but for graphic timer 
	
	Thread timerThread; // the thread that the timer is run on 
	
	// constructor 
	public BoardMenuTimerPanel(long time) {
		
		// Take out at Beta
		this.time = time;
		remainingTime = time;
		
		
		/*this.timerBar = time;
		currentTimeBar = timerBar; // not until Beta but for graphic timer 
		*/
		
		setPreferredSize(new Dimension(300, 45));
		setFont(timerFont);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1,2));
		
		// Take out at Beta
		setTime(time); // sets the time for the game
		
		// adds the JLabel to the screen 
		JLabel timer = new JLabel("Time Remaining: ");
		timer.setFont(timerFont);
		add(timer);	
	}

	// Take out at Beta 
	// sets the time into minutes and seconds 
	private void setTime(long time) {
		this.time = time;
		long minutes = (time / 60) % 60;
		long seconds = time % 60;
		timeString = String.format("%02d:%02d", minutes, seconds);
		repaint(); // updates the panel for the timer
	}
	
	// how much of the timer will be undone at a time 
	private void burnTimer(int amount){
		currentTimeBar -= amount;
		if(currentTimeBar < 0){
			currentTimeBar = 0;
		}
		calculateWidth();
	}
	
	// calculates the width of the timer bar on tick event
	private void calculateWidth(){
		double percent = currentTimeBar / timerBar;
		currentWidth = (int) (percent * WIDTH);
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
		// Take out at Beta
		setTime(remainingTime);
		
		// resets the timer to the full length of the bar
		/*currentTimeBar = timerBar;
		calculateWidth();*/
	}
	
	// paints the graphics onto the screen
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		//draw(g); // not used until Beta Creates the graphic timer 
		
		g.drawString(timeString, 150, 30); // take out at Beta
		repaint();
	}
	
	// For Beta to make the time graphic instead of timer
	// Draws the timer bar onto the screen
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(X, Y, currentWidth, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(X, Y, WIDTH, HEIGHT);
	}

	// what to do on tick for the runnable
	@Override
	public void run() {
		// take this out at Beta
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
		
		// will add this for beta version
		/*while(currentTimeBar > 0){
			burnTimer(1);
			try{
				Thread.sleep(1000);
			}
			catch(InterruptedException e){
				return;
			}
		}*/
		
		timesUp();
	}
	
	// Options allows you to start the game again if you so choose.
	public void timesUp(){
		int value = JOptionPane.showConfirmDialog(null, "Time is up! Do you want to play again?", 
				"Play Again?", JOptionPane.YES_NO_OPTION);
		
		switch(value){
		case 0:
			PlayerModel model = new PlayerModel(0, 1000, 30);
			model.resetPanel(); // resets the score panel back to original values
			break;
		case 1:
			System.exit(0); // terminates the game 
			break;
		}	
	}
}
