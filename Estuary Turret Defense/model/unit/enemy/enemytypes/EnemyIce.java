package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyIce extends EnemyModel {
	public EnemyIce() {
		setName("Ice");
		setFactDescription("Free-floating ice can dislodge and kill plants and shoreline"
				+ "animals that lie in its path.");
		setGameDescription("Ice can be more harmful than meets the eye!");
		setIcon(null);
		setBounty(10);
		setxCor(1);
		setyCor(1);
		setMaxHealth(50);
		setScoreValue(25);
		setSpeed(6);
		setPositionIndex(0);
	}
	
}
