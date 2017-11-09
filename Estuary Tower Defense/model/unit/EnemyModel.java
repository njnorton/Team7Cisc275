package unit;

/**
 * The super class for all enemy types. It contains the attributes 
 * that all enemies should have and inherits from UnitModel.
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 * 
 */

/*
 * Variable Dictionary:
 * int bounty: an integer representing how much money you make from the thing getting killed
 * int currentHealth: an integer representing the amount of health that the unit currently has
 * int positionIndex: an integer representing the position on the path the enemy is on
 * int scoreValue: an integer representing the point value received for defeating the enemy
 * int speed: an integer representing the number of indices the enemy moves each tick
 */
public abstract class EnemyModel extends UnitModel {

	int maxHealth;
	int currentHealth;
	int bounty;
	int speed;
	int scoreValue;
	int positionIndex;
	
	public int getBounty() {
		return bounty;
	}
	public void setBounty(int bounty) {
		this.bounty = bounty;
	}
	public int getMaxHealth() {
		return maxHealth;
	}
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}
	public int getCurrentHealth() {
		return currentHealth;
	}
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public int getScoreValue() {
		return scoreValue;
	}
	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}
	
	public int getPositionIndex() {
		return positionIndex;
	}
	public void setPositionIndex(int positionIndex) {
		this.positionIndex = positionIndex;
	}
	
}
