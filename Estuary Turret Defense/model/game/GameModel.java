package game;

import factory.EnemyFactory;
import factory.TurretFactory;
import player.PlayerModel;
//import unit.enemy.EnemyModel;
//import unit.turret.TurretModel;
import unit.enemy.EnemyModel;
import unit.turret.TurretModel;

public class GameModel {
	
	//TODO
	//Refactor? So it has a pointer to the game or something
	//The inputs may have to get changed if the game object cannot be in this class

	
	//TODO have a turret library of every possible turret to make so we can do price looksups?
	//At the very least a price library may be required
	// fields to be added 
	public GameObj game;
	TurretFactory turretFactory;
	EnemyFactory enemyFactory;
	public PlayerModel player;
	
	//private gameMenuScorePanel gameMenu; // allows for the use of controlling the view of the side panel
	
	public GameModel(){
		game = new GameObj();
		turretFactory = new TurretFactory();
		enemyFactory = new EnemyFactory();
		player = new PlayerModel();
		player.setMoney(200);
		player.setHealth(10);
	}

	
	/* Methods to be added for the game Controller Class. 
	   Will have to change the return types of each of the
	   methods when more of this is defined. 
	 */
	
	
	//Sees if the Reload Count for a turret is zero, if it is it returns true (it can fire)
	//If it is not zero, reduce the turret's reload count by 1, and return false
	public boolean checkReloadCount(int turretInd){
		if (game.turretList.get(turretInd).getReloadCount() == 0){
			return true;
		}
		else{
			game.turretList.get(turretInd).setReloadCount(game.turretList.get(turretInd).getReloadCount()-1);
			return false;
		}
	}
	
	public void resetReload(int turretInd){
		game.turretList.get(turretInd).setReloadCount(game.turretList.get(turretInd).getReloadTime());
	}
	
	
	//Checks the range of the turret versus the enemy, if it is range it returns true
	//If it is not in range it returns false
	public boolean checkRange(int turretInd, int enemyInd){
		System.out.println("Try Check Range");
		int xDis = game.turretList.get(turretInd).getxCor() - game.enemyList.get(enemyInd).getxCor();
		int yDis = game.turretList.get(turretInd).getyCor() - game.enemyList.get(enemyInd).getyCor();
		double Dis = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));
		
		if (Dis > game.turretList.get(turretInd).getRange()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// adds damage to the current object that is on the game 
	// if the enemy is killed, return true
	public boolean damageEnemy(int turretInd, int enemyInd){
		game.enemyList.get(enemyInd).setCurrentHealth(game.enemyList.get(enemyInd).getCurrentHealth() - game.turretList.get(turretInd).getDamage());
		return checkHealth(enemyInd);
	}
	
	//Checks the enemy's health, if it is zero or lower then returns true, else returns false
	public boolean checkHealth(int enemyInd){
		System.out.println("Current baddie health: " + game.enemyList.get(enemyInd).getCurrentHealth());
		if (0 > game.enemyList.get(enemyInd).getCurrentHealth()){
			return true;
		}
		else{
			return false;
		}
	}
	
	// removes the object from it's respective array 
	public void removeEnemy(int enemyInd){
		game.enemyList.remove(enemyInd);
	}
	
	//Moves the enemy forward, removing it if it falls out of bound
	//if it is removed via falling out of bound, return true
	
	public boolean moveEnemy(int enemyInd){
		int moveInd = game.enemyList.get(enemyInd).getPositionIndex() + game.enemyList.get(enemyInd).getSpeed(); 
		if (game.path.getSize() > moveInd){
			game.enemyList.get(enemyInd).setxCor(game.path.getxCorAtIndex(moveInd));
			game.enemyList.get(enemyInd).setyCor(game.path.getyCorAtIndex(moveInd));
			game.enemyList.get(enemyInd).setPositionIndex(moveInd);
			return false;
		}
		else{
			removeEnemy(enemyInd);
			return true;
		}
	}
	
<<<<<<< HEAD:Estuary Turret Defense/src/board/BoardController.java
/*	public void moveEnemies() {
		for(EnemyModel em : Board.EnemyList) {
			
		}
	}*/
	
	// spawns an enemy onto the board 
=======
	// spawns an enemy onto the game 
>>>>>>> aaba16a46628bef4890fa17be985af31c8eb9dcd:Estuary Turret Defense/src/game/GameController.java
	public void spawnEnemy(String enemyName){
		EnemyModel enemy = enemyFactory.makeEnemy(enemyName);
		enemy.setxCor(game.path.getxCorAtIndex(0));
		enemy.setxCor(game.path.getyCorAtIndex(0));
		game.enemyList.add(enemy);
	}
	
	//spawns a turret on a given xCor yCor
	public void spawnTurret(String turretName, int xCor, int yCor){
		TurretModel turret = turretFactory.makeTurret(turretName);
		turret.setxCor(game.path.getxCorAtIndex(xCor));
		turret.setyCor(game.path.getyCorAtIndex(yCor));
		game.turretList.add(turret);
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
	
	//gain an amount of money equal to the bounty value of the enemy
	public void gainBounty(int enemyInd){
		increasePlayerMoney(game.enemyList.get(enemyInd).getBounty());
	}
	
	
	//Cheacks the players health, if false they are dead
	public boolean checkPlayerIsDead(){
		if (0 >= player.getHealth()){
			return true;
		}else{
			return false;
		}
	}
	//Increase the players score by a given amount
	//Then return the player's score
	public void increaseScore(int inc){
		player.setScore(player.getScore() + inc);
	}
	//Set the time to a given amount OR reduce the time by a given amount
	public void setTime(int time){
		player.setTime(time);
	}
	
	public void reduceTime(int time){
		player.setTime(player.getTime() - time);
	}
	
	
	// will start the round 
	public void startRound(){
		player.updateScore(12);
	}
	
	// will end the current round 
	public void endRound(){
		resetScorePanel(); // resets the scorePanel in the game
	}
	
	// updates the current score of the game 
	public void updateScore(int score){
		player.updateScore(score);
	}
	
	 // updates the remaining sandDollars left 
	public void updateSandDollars(int sandDollars){
		player.updateSandDollars(sandDollars);
	}
	
	// updates the health status 
	public void updateHealth(int healthLost){
		player.updateHealth(healthLost);
	}
	
	// allows the purchase of items from buttons clicked
	public void purchaseItem(TurretModel model){
		player.purchaseItem(model);
	}
	
	// rests the score panel after the conclusion of the game 
	public void resetScorePanel(){
		player.resetPanel();
	}
}
