package main;

/**
 * A container for the attributes of the game that are relevant and related to
 * the player.
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 */

/*
 * Variable Dictionary:
 * int health: an integer representing the amount of units that are allowed to reach
 * 			   the end of the path before the game ends
 * int money: an integer representing the amount of currency that the player can spend
 * 			  on units and upgrades
 * int roundTime: an integer representing the total amount of time per round
 * int score: an integer representing the total score that the player currently has
 * int timeLeft: an integer representing the remaining time left in the current round
 */
public class PlayerModel {
	int money;
	int health;
	int score;
	long roundTime;
	static long timeLeft;
	
	public int getMoney() {
		return money;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

	public long getRoundTime() {
		return roundTime;
	}

	public void setRoundTime(long roundTime) {
		this.roundTime = roundTime;
	}

	public long getTimeLeft() {
		return timeLeft;
	}

	public void setTimeLeft(long updatedTimeLeft) {
		timeLeft = updatedTimeLeft;
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
	
}
