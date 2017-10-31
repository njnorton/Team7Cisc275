package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyChemicals extends EnemyModel {
	public EnemyChemicals() {
		setName("Hazardous Chemicals");
		setFactDescription("Put hazardous waste in its place!");
		setGameDescription("Someone didn't properly dispose of their chemicals!");
		setIcon(null);
		setBounty(15);
		setxCor(1);
		setyCor(1);
		setMaxHealth(200);
		setScoreValue(75);
		setSpeed(1);
		setPositionIndex(0);
	}
}
