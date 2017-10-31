package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyLitter extends EnemyModel {
	public EnemyLitter() {
		setName("Litter");
		setFactDescription("Make sure to place waste in the proper receptacles!");
		setGameDescription("Someone didn't throw away their trash!");
		setIcon(null);
		setBounty(15);
		setxCor(1);
		setyCor(1);
		setCurrentHealth(125);
		setScoreValue(50);
		setSpeed(2);
		setPositionIndex(0);
	}
}
