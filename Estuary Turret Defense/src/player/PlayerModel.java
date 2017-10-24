package player;

import boardMenuView.BoardMenuSideGamePanel;

public class PlayerModel {
	int money;
	int health;
	
	public int getMoney() {
		return money;
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
}
