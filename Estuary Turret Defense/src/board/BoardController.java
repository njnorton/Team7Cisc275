package board;

import boardMenuView.BoardMenuScorePanel;
import factory.EnemyFactory;
import factory.TurretFactory;
//import unit.enemy.EnemyModel;
//import unit.turret.TurretModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class BoardController {

	// fields to be added 
	BoardModel Board;
	TurretFactory TurretFactory;
	EnemyFactory EnemyFactory;
	
	BoardMenuScorePanel boardMenu; // allows for the use of controlling the view of the side panel
	
	public BoardController(){
		Board = new BoardModel();
		TurretFactory = new TurretFactory();
		EnemyFactory = new EnemyFactory();
	}
	
	/* Methods to be added for the Board Controller Class. 
	   Will have to change the return types of each of the
	   methods when more of this is defined. 
	 */
	
	
	//Sees if the Reload Count for a turret is zero, if it is it returns true (it can fire)
	//If it is not zero, reduce the turret's reload count by 1, and return false
	public boolean checkReloadCount(int turretInd){
		if (Board.TurretList.get(turretInd).getReloadCount() == 0){
			return true;
		}
		else{
			Board.TurretList.get(turretInd).setReloadCount(Board.TurretList.get(turretInd).getReloadCount()-1);
			return false;
		}
	}
	
	
	//Checks the range of the turret versus the enemy, if it is range it returns true
	//If it is not in range it returns false
	public boolean checkRange(int turretInd, int enemyInd){
		int xDis = Board.TurretList.get(turretInd).getxCor() - Board.EnemyList.get(enemyInd).getxCor();
		int yDis = Board.TurretList.get(turretInd).getyCor() - Board.EnemyList.get(enemyInd).getyCor();
		double Dis = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
		
		if (Dis > Board.TurretList.get(turretInd).getRange()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// adds damage to the current object that is on the board 
	public void damageEnemy(int turretInd, int enemyInd){
		Board.EnemyList.get(enemyInd).setCurrentHealth(Board.EnemyList.get(enemyInd).getCurrentHealth()-Board.TurretList.get(turretInd).getDamage());
		return;
	}
	
	//Checks the enemy's health, if it is zero or lower then returns true, else returns false
	public boolean checkHealth(int enemyInd){
		if (0 > Board.EnemyList.get(enemyInd).getCurrentHealth()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// removes the object from it's respective array
	public void removeEnemy(int enemyInd){
		Board.EnemyList.remove(enemyInd);
	}
	
	//Moves the enemy forward, removing it if it falls out of bound
	public void moveEnemy(int enemyInd){
		int moveInd = Board.EnemyList.get(enemyInd).getPositionIndex() + Board.EnemyList.get(enemyInd).getSpeed(); 
		if (Board.Path.getSize() > moveInd){
			Board.EnemyList.get(enemyInd).setxCor(Board.Path.getxCorAtIndex(moveInd));
			Board.EnemyList.get(enemyInd).setyCor(Board.Path.getyCorAtIndex(moveInd));
		}
		else{
			removeEnemy(enemyInd);
		}
	}
	
	// spawns an enemy onto the board 
	public void spawnEnemy(String enemyName){
		EnemyModel enemy = EnemyFactory.makeEnemy(enemyName);
		enemy.setxCor(Board.Path.getxCorAtIndex(0));
		enemy.setxCor(Board.Path.getyCorAtIndex(0));
		Board.EnemyList.add(enemy);
	}
	
	//spawns a turret on a given xCor yCor
	public void spawnTurret(String turretName, int xCor, int yCor){
		TurretModel turret = TurretFactory.makeTurret(turretName);
		turret.setxCor(Board.Path.getxCorAtIndex(xCor));
		turret.setxCor(Board.Path.getyCorAtIndex(yCor));
		Board.TurretList.add(turret);
	}
	
	// will start the round 
	public void startRound(){
		
	}
	
	// will end the current round 
	public void endRound(){
		resetScorePanel(); // resets the scorePanel in the game
	}
	
	// updates the current score of the game 
	public void updateScore(int score){
		boardMenu.updateScore(score);
	}
	 // updates the remaining sandDollars left 
	public void updateSandDollars(int sandDollars){
		boardMenu.updateSandDollars(sandDollars);
	}
	
	// updates the health status 
	public void updateHealth(int healthLost){
		boardMenu.updateHealth(healthLost);
	}
	
	// allows the purchase of items from buttons clicked
	public void purchaseItem(TurretModel model){
		boardMenu.purchaseItem(model);
	}
	
	// rests the score panel after the conclusion of the game 
	public void resetScorePanel(){
		boardMenu.reset();
	}
}
