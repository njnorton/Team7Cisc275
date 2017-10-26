package player;

import boardMenuView.BoardMenuSideGamePanel;
import unit.turret.TurretModel;

public class PlayerModel {
	int money;
	int health;
	int score;
	int time;
	
	public int getMoney() {
		return money;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getHealth() {
		return health;
	}
	public void setHealth(int health) {
		this.health = health;
	}
	
	// correctly calls the function to update the score 
	public void updateScore(int score){
		BoardMenuSideGamePanel.scorePanel.updateScore(score);
	}
	
	 // updates the remaining sandDollars left 
	public void updateSandDollars(int sandDollars){
		BoardMenuSideGamePanel.scorePanel.updateSandDollars(sandDollars);
	}
		
	// updates the health status 
	public void updateHealth(int healthLost){
		BoardMenuSideGamePanel.scorePanel.updateHealth(healthLost);
	}
	
	// allows the purchase of items from buttons clicked
	public void purchaseItem(TurretModel model){
		BoardMenuSideGamePanel.scorePanel.purchaseItem(model);
	}
		
	// rests the score panel after the conclusion of the game 
	public void resetPanel(){
		BoardMenuSideGamePanel.scorePanel.reset(); // resets the score panel 
		BoardMenuSideGamePanel.timerPanel.stopTimer(); // stops the timer
		BoardMenuSideGamePanel.timerPanel.reset(); // resets the timer panel
	}
}
