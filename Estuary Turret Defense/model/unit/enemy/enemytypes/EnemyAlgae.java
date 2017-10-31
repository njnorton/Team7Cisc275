package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyAlgae extends EnemyModel {
	public EnemyAlgae() {
		setName("Pfiesteria");
		setFactDescription("Pfiesteria releases very powerful toxins into the water.");
		setGameDescription("A dangerous, toxic algae.");
		setIcon(null);
		setBounty(15);
		setxCor(1);
		setyCor(1);
		setMaxHealth(50);
		setScoreValue(75);
		setSpeed(7);
		setPositionIndex(0);
		
	}
}
