package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyPathogen extends EnemyModel {
	public EnemyPathogen() {
		setName("Pathogen");
		setFactDescription("The oyster diseases, MSX and Dermo, have resulted in a significant"
				+ "decline in the oyster population.");
		setGameDescription("A nasty disease that will infect your estuary.");
		setIcon(null);
		setBounty(20);
		setxCor(1);
		setyCor(1);
		setMaxHealth(175);
		setScoreValue(75);
		setSpeed(4);
		setPositionIndex(0);
	}

}
