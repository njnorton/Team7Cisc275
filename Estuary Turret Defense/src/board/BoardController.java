package board;

import boardMenuView.BoardMenuScorePanel;
import factory.EnemyFactory;
import factory.TurretFactory;
import player.PlayerModel;
//import unit.enemy.EnemyModel;
//import unit.turret.TurretModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class BoardController {
	
	//TODO
	//Refactor? So it has a pointer to the board or something
	//The inputs may have to get changed if the board object cannot be in this class

	
	//TODO have a turret library of every possible turret to make so we can do price looksups?
	//At the very least a price library may be required
	// fields to be added 
	BoardModel board;
	TurretFactory turretFactory;
	EnemyFactory enemyFactory;
	PlayerModel player;
	
	private BoardMenuScorePanel boardMenu; // allows for the use of controlling the view of the side panel
	
	public BoardController(){
		board = new BoardModel();
		turretFactory = new TurretFactory();
		enemyFactory = new EnemyFactory();
		player = new PlayerModel();
		player.setMoney(200);
		player.setHealth(10);
	}

	
	/* Methods to be added for the Board Controller Class. 
	   Will have to change the return types of each of the
	   methods when more of this is defined. 
	 */
	
	
	//Sees if the Reload Count for a turret is zero, if it is it returns true (it can fire)
	//If it is not zero, reduce the turret's reload count by 1, and return false
	public boolean checkReloadCount(int turretInd){
		if (board.TurretList.get(turretInd).getReloadCount() == 0){
			return true;
		}
		else{
			board.TurretList.get(turretInd).setReloadCount(board.TurretList.get(turretInd).getReloadCount()-1);
			return false;
		}
	}
	
	public void resetReload(int turretInd){
		board.TurretList.get(turretInd).setReloadCount(board.TurretList.get(turretInd).getReloadTime());
	}
	
	
	//Checks the range of the turret versus the enemy, if it is range it returns true
	//If it is not in range it returns false
	public boolean checkRange(int turretInd, int enemyInd){
		System.out.println("Try Check Range");
		int xDis = board.TurretList.get(turretInd).getxCor() - board.EnemyList.get(enemyInd).getxCor();
		int yDis = board.TurretList.get(turretInd).getyCor() - board.EnemyList.get(enemyInd).getyCor();
		double Dis = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
		
		if (Dis > board.TurretList.get(turretInd).getRange()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// adds damage to the current object that is on the board 
	// if the enemy is killed, return true
	public boolean damageEnemy(int turretInd, int enemyInd){
		board.EnemyList.get(enemyInd).setCurrentHealth(board.EnemyList.get(enemyInd).getCurrentHealth() - board.TurretList.get(turretInd).getDamage());
		return checkHealth(enemyInd);
	}
	
	//Checks the enemy's health, if it is zero or lower then returns true, else returns false
	public boolean checkHealth(int enemyInd){
		System.out.println("Current baddie health: " + board.EnemyList.get(enemyInd).getCurrentHealth());
		if (0 > board.EnemyList.get(enemyInd).getCurrentHealth()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// removes the object from it's respective array 
	public void removeEnemy(int enemyInd){
		board.EnemyList.remove(enemyInd);
	}
	
	//Moves the enemy forward, removing it if it falls out of bound
	//if it is removed via falling out of bound, return true
	
	public boolean moveEnemy(int enemyInd){
		int moveInd = board.EnemyList.get(enemyInd).getPositionIndex() + board.EnemyList.get(enemyInd).getSpeed(); 
		if (board.Path.getSize() > moveInd){
			board.EnemyList.get(enemyInd).setxCor(board.Path.getxCorAtIndex(moveInd));
			board.EnemyList.get(enemyInd).setyCor(board.Path.getyCorAtIndex(moveInd));
			board.EnemyList.get(enemyInd).setPositionIndex(moveInd);
			return false;
		}
		else{
			removeEnemy(enemyInd);
			return true;
		}
	}
	
	// spawns an enemy onto the board 
	public void spawnEnemy(String enemyName){
		EnemyModel enemy = enemyFactory.makeEnemy(enemyName);
		enemy.setxCor(board.Path.getxCorAtIndex(0));
		enemy.setxCor(board.Path.getyCorAtIndex(0));
		board.EnemyList.add(enemy);
	}
	
	//spawns a turret on a given xCor yCor
	public void spawnTurret(String turretName, int xCor, int yCor){
		TurretModel turret = turretFactory.makeTurret(turretName);
		turret.setxCor(board.Path.getxCorAtIndex(xCor));
		turret.setyCor(board.Path.getyCorAtIndex(yCor));
		board.TurretList.add(turret);
	}
	
	//Checks the price of the turret, returning true if the player can afford it or false if he cannot
	//TODO alter it so it doesn't have to make a turret to check price
	public boolean checkPrice(String turretName){
		TurretModel turret = turretFactory.makeTurret(turretName);
		if (player.getMoney() >= turret.getPrice()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Reduce the player's health by the given amount
	public void reducePlayerHealth(int i){
		player.setHealth(player.getHealth() - i);
	}
	
	//Reduce the player's money by the given amount
	public void reducePlayerMoney(int i){
		player.setMoney(player.getMoney() - i);
	}
	
	
	//Increase the player's money by the given amount
	public void increasePlayerMoney(int i){
		player.setMoney(player.getMoney() + i);
	}
	
	public void gainBounty(int enemyInd){
		increasePlayerMoney(board.EnemyList.get(enemyInd).getBounty());
	}
	
	
	//Cheacks the players health, if false they are dead
	public boolean checkPlayerIsDead(){
		if (0 >= player.getHealth()){
			return true;
		}else{
			return false;
		}
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
