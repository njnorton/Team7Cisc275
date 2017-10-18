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
	//Returns a boardmodel strictly for use in the concept testing of the game
	public BoardModel BoardConceptTest(){
		BoardModel Board = new BoardModel();
		
		//Create a dummy path that has 100 indexes, and goes from XPOS 0 to 100, and YPOS 0 to 0
		int[] xPath = new int[100];
		int[] yPath = new int[100];
		for (int i = 0; i<100; i++){
			xPath[i] = i;
		}
		for (int i = 0; i<100; i++){
			yPath[i] = 0;
		}
		Board.Path.setxCorArr(xPath);
		Board.Path.setyCorArr(yPath);
		return Board;
	}
}