package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyPoo extends EnemyModel {
	public EnemyPoo(){
		setName("Poo");
		setFactDescription("Clean up after your pets!");
		setGameDescription("A tough little shit");
		setIcon(null);
		setBounty(15);
		setId(0);
		setxCor(1);
		setyCor(1);
		setMaxHealth(150);
		setCurrentHealth(150);
		setScoreValue(50);
		setSpeed(1);
		setPositionIndex(0);
	}
}
