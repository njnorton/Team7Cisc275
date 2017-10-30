package unit.enemy;
import unit.UnitModel;
import position.Posn;

public abstract class EnemyModel extends UnitModel {
	//The current and max health of the enemy
	int maxHealth;
	int currentHealth;
	
	//Specifies an enemy
	int Id;
	
	//How much money you make from the thing getting killed
	int bounty;
	
	//How many indexes it moves by
	int speed;
	//How many points it is worth
	int scoreValue;
	
	//What position on the Path the enemy is on
	int positionIndex;
	
	//What cardinal direction is the enemy moving in?
	String direction;
	
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
	
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	
	//Update position based on speed while reporting whether the next position is reached
	//Called from GameModel
	public boolean updatePosition(Posn nextPosn) {
		switch(direction) {
			case "Up" : if(getPosn().getY() - speed <= nextPosn.getY()) {  //Check if the enemy would reach or pass the next point in the path
				this.setPosn(nextPosn);                                    //If it would, bring it to that position
				return true;                                               //Report that the next position was reached
			}
			else {
				this.getPosn().moveY(-speed);                              //Otherwise move in given direction
			}
			break;                                                         //Break and report next point not reached
			case "Down" : if(getPosn().getY() + speed >= nextPosn.getY()) {
				this.setPosn(nextPosn);
				return true;
			}
			else {
				this.getPosn().moveY(speed);
			}
			break;
			case "Left" : if(getPosn().getX() - speed <= nextPosn.getX()) {
				this.setPosn(nextPosn);
				return true;
			}
			else {
				this.getPosn().moveX(-speed);
			}
			break;
			case "Right" : if(getPosn().getX() + speed <= nextPosn.getX()) {
				this.setPosn(nextPosn);
				return true;
			}
			else {
				this.getPosn().moveX(speed);
			}
			break;
		}
		return false;
	}
	//Update direction according to the enemy's next destination
	//Called from GameModel
	public void updateDirection(Posn nextPosn) {
		this.setPositionIndex(positionIndex + 1);
		if(nextPosn.getX() == getPosn().getX()) {     //If the next destination is on a vertical path
			if(nextPosn.getY() < getPosn().getY()) {  //find which direction the enemy will travel
				setDirection("Up");                  //and set that direction
			}
			else {
				setDirection("Down");
			}
		}
		else{                                        //Otherwise the next destination is on a horizontal path
			if(nextPosn.getX() < getPosn().getX()) {  //and we check and set that direction
				setDirection("Left");
			}
			else {
				setDirection("Right");
			}
		}
	}
	
}
