package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyPoo extends EnemyModel {
	public EnemyPoo(){
		setName("Animal Waste");
		setFactDescription("Clean up after your pets!");
		
		//TODO Change and update facts, icons, balance the units
		
		setGameDescription("A tough little poop.");
		setIcon(null);
		setBounty(15);
		setxCor(1);
		setyCor(1);
		setMaxHealth(150);
		setCurrentHealth(150);
		setScoreValue(50);
		setSpeed(3);
		setPositionIndex(0);
	}
}
