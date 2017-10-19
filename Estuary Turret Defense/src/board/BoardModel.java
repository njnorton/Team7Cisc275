package board;

import java.util.ArrayList;

import path.PathModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class BoardModel {
	ArrayList<EnemyModel> EnemyList;
	ArrayList<TurretModel> TurretList;
	//Inside of the path is the first and last position index
	PathModel Path;
	

	
	
	public BoardModel(){
		EnemyList = new ArrayList<EnemyModel>();
		TurretList = new ArrayList<TurretModel>();
		Path = new PathModel();
	}

}