package unit.enemy;
import unit.UnitModel;

public abstract class EnemyModel extends UnitModel {
	//The current and max health of the enemy
	int maxHealth;
	int currentHealth;
	
	//Specifies an enemy
	int Id;
	
	//How many indexes it moves by
	int speed;
	//How many points it is worth
	int scoreValue;
	
	//What position on the Path the enemy is on
	int positionIndex;
	
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
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
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
