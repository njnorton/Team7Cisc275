package factory;

import unit.enemy.*;
import unit.enemy.enemytypes.*;

public class EnemyFactory {
	public EnemyModel makeEnemy(String enemyName){
		
		EnemyModel newEnemy = null;
		
		switch (enemyName){
			case "Poo" :
				newEnemy = new EnemyPoo();
				break;
			default:
				//throw exception
				break;
		}
		return newEnemy;
	}
}
