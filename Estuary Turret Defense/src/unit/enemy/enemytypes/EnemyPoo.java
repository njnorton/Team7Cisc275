package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyPoo extends EnemyModel {
	public EnemyPoo(){
		setName("Poo");
		setFactDescription("Clean up after your pets!");
		setGameDescription("A dangerous little shit");
		setIcon(null);
		setId(null);
		setxCor(1);
		setyCor(1);
		setHealth(100);
		setScoreValue(50);
		setSpeed(1000);
	}
}
