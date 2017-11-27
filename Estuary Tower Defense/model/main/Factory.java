package main;

import unit.EnemyModel;
import unit.TowerModel;
import unit.enemyTypes.EnemyPoo;
import unit.towerTypes.TowerGenericShellfish;
import unit.towerTypes.TowerGenericBird;
import unit.towerTypes.TowerGenericFish;
/**
 * A utilization of the factory design pattern to generate gameplay objects
 * such as turrets and enemies.
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 *
 */
public class Factory {
	/**
	 * Returns an instance of an enemy corresponding to the passed in string. This object
	 * will be placed in an ArrayList of enemies to be interacted with in the model logic.
	 * @param	enemyName	a string describing the enemy to be generated
	 * @return	EnemyModel	an instance of the enemy corresponding to the passed in string 
	 */
	public EnemyModel makeEnemy(String enemyName) {
		EnemyModel newEnemy = null;
		
		switch(enemyName) {
			case "Poo" :
				newEnemy = new EnemyPoo();
				break;
			default:
				break;
		}
		
		return newEnemy;
	}
	/**
	 * Returns an instance of a tower corresponding to the passed in string. This object
	 * will be placed in an ArrayList of towers to be interacted with in the model logic.
	 * @param	towerName	a string describing the tower to be generated
	 * @return	TowreModel	an instance of the tower corresponding to the passed in string
	 */
	public TowerModel makeTower(String towerName) {
		TowerModel newTower = null;
		
		switch(towerName) {
			case "Generic Bird" :
				newTower = new TowerGenericBird();
				break;
			case "Generic Shellfish" :
				newTower = new TowerGenericShellfish();
				break;
			case "Generic Fish" :
				newTower = new TowerGenericFish();
				break;
			default:
				break;
		}
		return newTower;
	}
}
