package unit.enemyTypes;

import unit.EnemyModel;

public class EnemyLitter extends EnemyModel {
	public EnemyLitter(){
		setName("EnemyLitter");
		setxCor(0);
		setyCor(0);
		setBounty(15);
		setMaxHealth(175);
		setCurrentHealth(175);
		setSpeed(4);
		setScoreValue(15);
		setPositionIndex(0);
	}
}
