package unit.enemy.enemytypes;

import unit.enemy.EnemyModel;

public class EnemyRunoff extends EnemyModel {
	public EnemyRunoff() {
		setName("Storm Runoff");
		setFactDescription("Rain and melting snow can carry litter and other contaminants"
				+ "storm drains and waterways.");
		setGameDescription("A slippery bucket of dirty water.");
		setIcon(null);
		setBounty(20);
		setxCor(1);
		setyCor(1);
		setMaxHealth(100);
		setScoreValue(75);
		setSpeed(5);
		setPositionIndex(0);
	}
}
