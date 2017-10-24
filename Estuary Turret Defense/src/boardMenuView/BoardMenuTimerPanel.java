package boardMenuView;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class BoardMenuTimerPanel extends JPanel implements Runnable {

	private static final long serialVersionUID = 1L;

	private long time = 0;
	private long remainingTime = 0;
	private String timeString = "00:00";
		
	private Font timerFont = new Font(Font.DIALOG, Font.PLAIN, 16); // sets font 

	Thread timerThread;

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

	private void setTime(long time) {
		this.time = time;
		long minutes = (time / 60) % 60;
		long seconds = time % 60;
		timeString = String.format("%02d:%02d", minutes, seconds);
		repaint(); // updates the panel for the timer
	}

	public void startTimer() {
		stopTimer();
		timerThread = new Thread(this);
		timerThread.start();
	}

	public void stopTimer() {
		if(timerThread != null){
			timerThread.interrupt();
			timerThread = null;
		}
	}
	
	public void reset(){
		setTime(remainingTime);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawString(timeString, 150, 30);
		repaint();
	}

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
	}
}
