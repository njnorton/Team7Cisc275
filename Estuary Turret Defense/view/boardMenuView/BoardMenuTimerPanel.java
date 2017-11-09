package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import gameController.GameController;

public class BoardMenuTimerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public long time; // the time that is passed in
	private static String timeString; // the time string representation of the countdown
	boolean isRoundActive;

	private Font timerFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font

	private final int WIDTH = 150; // width of timer bar graphics
	private final int HEIGHT = 20; // height of timer bar graphics 
	private final int X = 140; // location x coordinate of graphics timer 
	private final int Y = 13; // location y coordinate of graphics timer 

	private int currentWidth = WIDTH; // current width of the timer bar measured against the moving timer
	private double currentTimeBar = 0; // total time that is still left on the timer bar 

	Thread timerThread; // the thread that the timer is run on

	// constructor
	public BoardMenuTimerPanel() {
		timeString = "00:00";

		setPreferredSize(new Dimension(300, 45));
		setFont(timerFont);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2));

		// adds the JLabel to the screen
		JLabel timer = new JLabel("Time Remaining: ");
		timer.setFont(timerFont);
		add(timer);
	}

	// Take out at Beta
	// sets the time into minutes and seconds
	public void setTime(long roundTime) {
		time = roundTime;
		currentTimeBar = time;
		long minutes = (time / 60) % 60;
		long seconds = time % 60;
		timeString = String.format("%02d:%02d", minutes, seconds);
		repaint(); // updates the panel for the timer
	}

	// how much of the timer will be undone at a time
	private void burnTimerBar(int amount) {
		currentTimeBar -= amount;
		if (currentTimeBar < 0) {
			currentTimeBar = 0;
		}
		calculateWidth();
	}

	// calculates the width of the timer bar on tick event
	private void calculateWidth() {
		double percent = (double) GameController.model.player.getTimeLeft() / GameController.model.player.getRoundTime();
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
		if (timerThread != null) {
			timerThread.interrupt();
			timerThread = null;
		}
	}

	// rests the clock to given time
	public void reset() {
		// resets the timer to the full length of the bar
		currentTimeBar = time; 
		calculateWidth(); 
	}

	// paints the graphics onto the screen
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g); // not used until Beta Creates the graphic timer
		g.drawString(timeString, 190, 29); // take out at Beta
		repaint();
	}

	// For Beta to make the time graphic instead of timer
	// Draws the timer bar onto the screen
	public void draw(Graphics g) {
		if(time > (int)GameController.model.player.getRoundTime()*1/4 || time == (int)GameController.model.player.getRoundTime()){
			g.setColor(Color.GREEN);
		}else if(time >= 0 || time <= (int)GameController.model.player.getRoundTime()*1/4){
			g.setColor(Color.RED);
		}
		g.fillRect(X, Y, currentWidth, HEIGHT);
		g.setColor(Color.BLACK);
		g.drawRect(X, Y, WIDTH, HEIGHT);
	}

	@Override
	public void run() {
		
		while (GameController.model.player.getTimeLeft() > 0) {
			try {
				Thread.sleep(1000);
				System.out.println(GameController.model.player.getTimeLeft());
			} catch (InterruptedException e) {
				return;
			}
			GameController.model.player.setTimeLeft(GameController.model.player.getTimeLeft() - 1);
			setTime(GameController.model.player.getTimeLeft());
			burnTimerBar(1);
		}
//		while (GameController.isRoundActive()) {
//			GameController.timeTick();
//			try {
//				Thread.sleep(1000);
//				System.out.println(GameController.model.player.getTimeLeft());
//			} catch (InterruptedException e) {
//				return;
//			}
//		}

//		will add this for beta version
//		while (currentTimeBar > 0) {
//			burnTimer(1);
//			try {
//				Thread.sleep(1000);
//			} catch (InterruptedException e) {
//				return;
//			}
//		}

		timesUp();

	}

	//TODO when time is up, enable start round button again
	// Options allows you to start the game again if you so choose.
	public void timesUp() {
		JOptionPane.showMessageDialog(null, "This round has ended. Start the next round when you're ready!");
		GameController.model.player.setTimeLeft(GameController.model.player.getRoundTime());
		GameController.view.boardMenu.sidePanel.startButton.setEnabled(true);
		GameController.view.boardMenu.sidePanel.endButton.setEnabled(false);
	}
	
	public void setRoundActive(boolean isRoundActive) {
		this.isRoundActive = isRoundActive;
	}
}
