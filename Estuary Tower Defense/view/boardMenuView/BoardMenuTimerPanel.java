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
/**
 * Keeps track of the time that is left in the game. It runs off of a thread so that 
 * the computers time is not the primary source of time so it can count down 1 second 
 * at a time. 
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */

/*
 * Variable Dictionary:
 * 
 * long time: the current time that is remaining on the clock when PlayerModel passes the value in
 * String timeString: the time representation in the form of a string to display on the screen
 * boolean isRoundActive: is the current round active in the game 
 * Font timerFont: the font that the timer will use for display purposes 
 * int WIDTH: the total width of the timer bar graphics 
 * int HEIGHT: the total height of the timer bar graphics 
 * int X: the x coordinate location of the graphics timer on the screen
 * int Y: the y coordinate location of the graphics timer on the screen
 * int TIMERSTRING_XCOORD: the x location of the timer string on the screen
 * int TIMERSTRING_YCOORD: the y location of the timer string on the screen
 * int currentWidth: the current width of the timer graphics bar on the screen
 * double currentTimeBar: the current amount of time that is left of the graphics bar 
 * Thread timerThread: the thread used for the timer 
 */

public class BoardMenuTimerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	public long time; // the time that is passed in
	private static String timeString; // the time string representation of the countdown
	boolean isRoundActive;

	private Font timerFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font

	private final int WIDTH = 115; // width of timer bar graphics
	private final int HEIGHT = 20; // height of timer bar graphics 
	private final int X = 140; // location x coordinate of graphics timer 
	private final int Y = 11; // location y coordinate of graphics timer 
	
	private final int TIMERSTRING_XCOORD = 175;
	private final int TIMERSTRING_YCOORD = 27;

	private int currentWidth = WIDTH; // current width of the timer bar measured against the moving timer
	private double currentTimeBar = 0; // total time that is still left on the timer bar 

	Thread timerThread; // the thread that the timer is run on

	/**
	 * Constructor to setup the entire timer panel on the side panel of the screen. 
	 * This will be used so that the user will be able to keep track of the time left 
	 * for each round when this completes the setup. 
	 */
	public BoardMenuTimerPanel() {
		timeString = "00:00";

		setPreferredSize(new Dimension(260, 35));
		setFont(timerFont);
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2));

		// adds the JLabel to the screen
		JLabel timer = new JLabel("Time Remaining: ");
		timer.setFont(timerFont);
		add(timer);
	}

	/**
	 * This takes the amount of seconds that the user enters and will convert it to
	 * a time representation in minutes and seconds for displaying on the screen. The 
	 * maximum amount of time that is able to be displayed is 99 minutes and 59 seconds. 
	 * 
	 * @param roundTime the amount of time in seconds that will appear on the screen
	 */
	public void setTime(long roundTime) {
		time = roundTime;
		currentTimeBar = time;
		long minutes = (time / 60) % 60;
		long seconds = time % 60;
		timeString = String.format("%02d:%02d", minutes, seconds);
		repaint(); // updates the panel for the timer
	}

	/**
	 * Will decrease the amount of time that is left on the timer bar graphic with 
	 * each second that goes by and makes a call to calculateWidth to set the width of 
	 * the bar. 
	 * 
	 * @param amount the amount of time that will be burned with each time tick
	 */
	private void burnTimerBar(int amount) {
		currentTimeBar -= amount;
		if (currentTimeBar < 0) {
			currentTimeBar = 0;
		}
		calculateWidth();
	}

	/**
	 * Calculates the total width of the remaining time left on the clock. Takes the time left 
	 * from the PlayerModel and divides it by the total round time that it was initially set to 
	 * at the beginning of the game.
	 */
	private void calculateWidth() {
		double percent = (double) GameController.model.player.getTimeLeft() / GameController.model.player.getRoundTime();
		currentWidth = (int) (percent * WIDTH);
	}

	/**
	 * Starts the time thread to count down each tick of time that passes by. 
	 * Makes a call to stopTimer to make sure that only one thread is running 
	 * at a time and not multiple. 
	 */
	public void startTimer() {
		stopTimer();
		timerThread = new Thread(this);
		timerThread.start();
	}

	/**
	 * Stops the time thread from counting down for the tick of the time that is 
	 * passing by. This will terminate the current thread that is running to stop the 
	 * clock.
	 */
	public void stopTimer() {
		if (timerThread != null) {
			timerThread.interrupt();
			timerThread = null;
		}
	}

	/**
	 * Resets the time bar graphics back to the full length of the bar. Will make a call
	 * back to calculateWidth to do a full reset of the time bar. 
	 */
	public void reset() {
		// resets the timer to the full length of the bar
		currentTimeBar = time; 
		calculateWidth(); 
	}

	/**
	 * Paints everything onto the screen for both the time graphics bar and the time 
	 * string. Makes a call to the draw method to set up the time graphics bar on the timer 
	 * panel. Will repaint after this method is done running. 
	 * 
	 * @param g the graphic that will be drawn onto the screen for the timer panel
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		draw(g); // draws the timer graphic bar onto the screen for the timer panel 
		g.drawString(timeString, TIMERSTRING_XCOORD, TIMERSTRING_YCOORD); // draws to specified location of timer string
		repaint();
	}

	/**
	 * Draws onto the screen the timer graphic bar for timer panel. When it reaches 1/4 of the 
	 * time left in the round, then it changes color to let the user know that there is limited 
	 * time left for the round. 
	 * 
	 * @param g the graphic that will be drawn onto the screen for the timer panel 
	 */
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

	/**
	 * The overriden method that takes care of what happens when the thread is running 
	 * for the timer. There is a series of calls that are being made when the timer is 
	 * being run. Will be a one second delay after each tick of the clock that is going by. 
	 */
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
	/**
	 * Displays a pop-up message when the time has reached zero letting the user know that 
	 * the round is over. It then enables certain buttons when this message is done at the 
	 * end of the round. 
	 */
	public void timesUp() {
		JOptionPane.showMessageDialog(null, "This round has ended. Start the next round when you're ready!");
		GameController.model.player.setTimeLeft(GameController.model.player.getRoundTime());
		GameController.view.boardMenu.buttonPanel.startButton.setEnabled(true);
	}
	
	/**
	 * Tells if the current round is active in the game. 
	 * 
	 * @param isRoundActive set to true or false, if the current round is active 
	 */
	public void setRoundActive(boolean isRoundActive) {
		this.isRoundActive = isRoundActive;
	}
}
