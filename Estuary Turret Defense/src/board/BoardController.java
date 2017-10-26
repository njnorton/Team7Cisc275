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
	BoardModel Board;
	TurretFactory TurretFactory;
	EnemyFactory EnemyFactory;
	PlayerModel Player;
	
	private BoardMenuScorePanel boardMenu; // allows for the use of controlling the view of the side panel
	
	public BoardController(){
		Board = new BoardModel();
		TurretFactory = new TurretFactory();
		EnemyFactory = new EnemyFactory();
		Player = new PlayerModel();
		Player.setMoney(200);
		Player.setHealth(10);
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
	
	public void resetReload(int turretInd){
		Board.TurretList.get(turretInd).setReloadCount(Board.TurretList.get(turretInd).getReloadTime());
	}
	
	
	//Checks the range of the turret versus the enemy, if it is range it returns true
	//If it is not in range it returns false
	public boolean checkRange(int turretInd, int enemyInd){
		System.out.println("Try Check Range");
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
	// if the enemy is killed, return true
	public boolean damageEnemy(int turretInd, int enemyInd){
		Board.EnemyList.get(enemyInd).setCurrentHealth(Board.EnemyList.get(enemyInd).getCurrentHealth()-Board.TurretList.get(turretInd).getDamage());
		return checkHealth(enemyInd);
	}
	
	//Checks the enemy's health, if it is zero or lower then returns true, else returns false
	public boolean checkHealth(int enemyInd){
		System.out.println("Current baddie health: " + Board.EnemyList.get(enemyInd).getCurrentHealth());
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
	//if it is removed via falling out of bound, return true
	
	public boolean moveEnemy(int enemyInd){
		int moveInd = Board.EnemyList.get(enemyInd).getPositionIndex() + Board.EnemyList.get(enemyInd).getSpeed(); 
		if (Board.Path.getSize() > moveInd){
			Board.EnemyList.get(enemyInd).setxCor(Board.Path.getxCorAtIndex(moveInd));
			Board.EnemyList.get(enemyInd).setyCor(Board.Path.getyCorAtIndex(moveInd));
			Board.EnemyList.get(enemyInd).setPositionIndex(moveInd);
			return false;
		}
		else{
			removeEnemy(enemyInd);
			return true;
		}
	}
	
/*	public void moveEnemies() {
		for(EnemyModel em : Board.EnemyList) {
			
		}
	}*/
	
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
		turret.setyCor(Board.Path.getyCorAtIndex(yCor));
		Board.TurretList.add(turret);
	}
	
	//Checks the price of the turret, returning true if the player can afford it or false if he cannot
	//TODO alter it so it doesn't have to make a turret to check price
	public boolean checkPrice(String turretName){
		TurretModel turret = TurretFactory.makeTurret(turretName);
		if (Player.getMoney() >= turret.getPrice()){
			return true;
		}
		else{
			return false;
		}
	}
	
	//Reduce the player's health by the given amount
	public void reducePlayerHealth(int i){
		Player.setHealth(Player.getHealth() - i);
	}
	
	//Reduce the player's money by the given amount
	public void reducePlayerMoney(int i){
		Player.setMoney(Player.getMoney() - i);
	}
	
	
	//Increase the player's money by the given amount
	public void increasePlayerMoney(int i){
		Player.setMoney(Player.getMoney() + i);
	}
	
	public void gainBounty(int enemyInd){
		increasePlayerMoney(Board.EnemyList.get(enemyInd).getBounty());
	}
	
	
	//Cheacks the players health, if false they are dead
	public boolean checkPlayerIsDead(){
		if (0 >= Player.getHealth()){
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
