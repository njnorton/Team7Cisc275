package unit.enemy;
import unit.UnitModel;

public abstract class EnemyModel extends UnitModel {
	int maxHealth;
	int currentHealth;
	int speed;
	int scoreValue;
	
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
	
}
