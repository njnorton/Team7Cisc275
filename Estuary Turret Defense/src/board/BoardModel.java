package board;

import java.util.ArrayList;

import path.PathModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class BoardModel {
	
	//Holds the fields manipulated in the gameplay
	
	
	ArrayList<EnemyModel> enemyList;
	ArrayList<TurretModel> turretList;
	//Inside of the path is the first and last position index
	PathModel Path;
	

	
	
	public BoardModel(){
		enemyList = new ArrayList<EnemyModel>();
		turretList = new ArrayList<TurretModel>();
		Path = new PathModel();
	}

}