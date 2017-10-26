package unit.enemy.enemytypes;
import unit.enemy.EnemyModel;


public class EnemyQuickShit extends EnemyModel {
	public EnemyQuickShit(){
		setName("QuickShit");
		setFactDescription("Clean up after your pets!");
		setGameDescription("A slippery little shit");
		setIcon(null);
		setBounty(15);
		setId(0);
		setxCor(1);
		setyCor(1);
		setMaxHealth(100);
		setCurrentHealth(100);
		setScoreValue(50);
		setSpeed(3);
		setPositionIndex(0);
	}
}

