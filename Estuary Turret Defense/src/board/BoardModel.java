package board;

import java.util.ArrayList;

import path.PathModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;
import factory.EnemyFactory;

public class BoardModel {
	ArrayList<EnemyModel> EnemyList;
	ArrayList<TurretModel> TurretList;
	PathModel Path;
	EnemyFactory EnemyFactory;
	
	public BoardModel(){
		
	}
}
