package game;

import java.util.ArrayList;

import path.PathModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class GameObj {
	
	//Holds the fields manipulated in the gameplay
	
	
	public ArrayList<EnemyModel> enemyList;
	public ArrayList<TurretModel> turretList;
	//Inside of the path is the first and last position index
	public PathModel path;
	
	public GameObj(){
		enemyList = new ArrayList<EnemyModel>();
		turretList = new ArrayList<TurretModel>();
		path = new PathModel();
	}

}