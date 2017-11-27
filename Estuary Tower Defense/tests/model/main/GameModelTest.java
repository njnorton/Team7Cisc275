package model.main;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Factory;
import main.GameModel;
import main.PathModel;
import main.PlayerModel;
import unit.EnemyModel;
import unit.TowerModel;
import unit.enemyTypes.EnemyPoo;

public class GameModelTest extends GameModel {	
	
	@Test
	public void isReloadingTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		TowerModel tower = fac.makeTower("GenericBird");
		game.path = path;
		game.factory = fac;
		game.towerList.add(tower);
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		boolean isLoading = game.isReloading(0);
		
		assertFalse("Tower Crab at index 0 is reloading", isLoading);
	}
	
	@Test
	public void isReloadingTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		TowerModel tower = fac.makeTower("GenericBird");
		tower.setReloadCount(3);
		game.path = path;
		game.factory = fac;
		game.towerList.add(tower);
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		boolean isLoading = game.isReloading(0);
		
		assertTrue("Tower Crab at index 0 is reloading", isLoading);
	}
	
	@Test
	public void resetReloadTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		TowerModel tower = fac.makeTower("GenericShellfish");
		game.path = path;
		game.factory = fac;
		game.towerList.add(tower);
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
			
		game.resetReload(0);
		
		assertEquals("Test to see if reload time is equal to 2", 2, game.towerList.get(0).getReloadTime());
	}
	
	@Test
	public void resetReloadTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		TowerModel tower = fac.makeTower("GenericFish");
		game.path = path;
		game.factory = fac;
		game.towerList.add(tower);
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
			
		game.resetReload(0);
		
		assertEquals("Test to see if reload time is equal to 2", 3, game.towerList.get(0).getReloadTime());
	}
	
	// TODO do isInRange testing x2
	@Test
	public void isInRangeTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		TowerModel tower = fac.makeTower("GenericFish");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		game.towerList.add(tower);
		
		int[] xCoord = {20,21};
		int[] yCoord = {40,41};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		boolean inRange = game.isInRange(0, 0);
		
		assertFalse("testing to see if the tower is in range of the enemy", inRange);
	}
	
	@Test
	public void isInRangeTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		TowerModel tower = fac.makeTower("GenericShellfish");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		game.towerList.add(tower);
		tower.setxCor(102);
		
		int[] xCoord = {0,150};
		int[] yCoord = {175,401};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		boolean inRange = game.isInRange(0, 0);
		
		assertTrue("testing to see if the tower is in range of the enemy", inRange);
	}
	
	@Test
	public void damageEnemyTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		TowerModel tower = fac.makeTower("GenericFish");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		game.towerList.add(tower);
		
		int[] xCoord = {20,21};
		int[] yCoord = {40,41};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		game.damageEnemy(0, 0);
	
		assertEquals("Test damage health against enemy", 130, game.enemyList.get(0).getCurrentHealth());
	}
	
	@Test
	public void damageEnemyTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		enemy.setCurrentHealth(50);
		TowerModel tower = fac.makeTower("GenericShellfish");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		game.towerList.add(tower);
		
		int[] xCoord = {20,21};
		int[] yCoord = {40,41};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		game.damageEnemy(0, 0);
	
		assertEquals("Test damage health against enemy", 0, game.enemyList.size());
	}
	
	@Test
	public void moveEnemyTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Poo");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		
		int[] xCoord = {0,1,2,3,4,5};
		int[] yCoord = {0,1,2,3,4,5};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
	
		game.moveEnemy(0);
		
		assertEquals("Test position index moved 5", 5, enemy.getPositionIndex());
	}
	
	@Test
	public void moveEnemyTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		EnemyModel enemy2 = fac.makeEnemy("Poo");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		game.enemyList.add(enemy2);
		
		int[] xCoord = {0,13,22,33,44,55};
		int[] yCoord = {0,21,32,23,34,15};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		game.moveEnemy(0);
		
		assertEquals("Test position index moved 5", 4, enemy.getPositionIndex());
	}
	
	@Test 
	public void isOutOfBoundsTest1(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Pathogen");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		
		int[] xCoord = {20,31};
		int[] yCoord = {60,21};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		path.setSize(1);
		enemy.setPositionIndex(2);
		
		boolean bounds = game.isOutOfBounds(0);
		
		assertTrue("Enemy is within bounds", bounds);
	}
	
	@Test 
	public void isOutOfBoundsTest2(){
		GameModel game = new GameModel();
		PathModel path = new PathModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Poo");
		game.path = path;
		game.factory = fac;
		game.enemyList.add(enemy);
		
		int[] xCoord = {10,1};
		int[] yCoord = {10,11};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		path.setSize(3);
		
				
		boolean bounds = game.isOutOfBounds(0);
		
		assertFalse("Enemy is not within bounds", bounds);
	}
	
	@Test
	public void spawnEnemyTest(){
		GameModel game = new GameModel();
		Factory fac = new Factory();
		EnemyModel enemy = fac.makeEnemy("Poo");
		PathModel path = new PathModel();
		game.factory = fac;
		game.path = path;
		game.enemyList.add(enemy);
		
		int[] xCoord = {20,11};
		int[] yCoord = {40,41};
		
		path.setxCorArr(xCoord);
		path.setyCorArr(yCoord);
		
		enemy.setxCor(path.getxCorAtIndex(0));
		enemy.setyCor(path.getyCorAtIndex(1));
		
		game.spawnEnemy("Poo");
		assertEquals("Test enemy creation", "EnemyPoo", game.enemyList.get(0).getName());
		assertEquals("Test EnemyPoo x coordinate", 20, game.enemyList.get(0).getxCor());
		assertEquals("Test EnemyPoo y coordinate", 41, game.enemyList.get(0).getyCor());
	}
	
	@Test
	public void spawnTowerTest(){
		GameModel game = new GameModel();
		Factory fac = new Factory();
		TowerModel tower = fac.makeTower("GenericBird");
		PathModel path = new PathModel();
		game.factory = fac;
		game.path = path;
		game.towerList.add(tower);
		
		int[] x = {11,21};
		int[] y = {1,21};
		
		path.setxCorArr(x);
		path.setyCorArr(y);
		
		tower.setxCor(path.getxCorAtIndex(1));
		tower.setyCor(path.getyCorAtIndex(0));
				
		game.spawnTower("GenericBird", 1, 1);
				
		assertEquals("Test Crab tower name check","Generic Bird", game.towerList.get(0).getName());
		assertEquals("Test Crab x Coordinate", 21, game.towerList.get(0).getxCor());
		assertEquals("Test Crab y Coordinate", 1, game.towerList.get(0).getyCor());
	}
	
	//TODO tests for isAffordable once method is fixed 
	
	@Test 
	public void reducePlayerHealthTest1(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setHealth(30);
		game.player = player; 
		
		game.reducePlayerHealth(5);
		
		assertEquals("Health was reduced by 5", 25, player.getHealth());
	}
	
	@Test 
	public void reducePlayerHealthTest2(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setHealth(30);
		game.player = player;
		
		game.reducePlayerHealth(25);
		
		assertEquals("Health was reduced by 25", 5, player.getHealth());
	}
	
	@Test 
	public void reducePlayerMoneyTest1(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(30);
		game.player = player;
		
		game.reducePlayerMoney(14);
		
		assertEquals("Money was reduced by 14", 16, player.getMoney());
	}
	
	@Test 
	public void reducePlayerMoneyTest2(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(50);
		game.player = player;
		
		game.reducePlayerMoney(10);
		
		assertEquals("Money was reduced by 10", 40, player.getMoney());
	}
	
	@Test 
	public void increasePlayerMoneyTest1(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(30);
		game.player = player;
		
		game.increasePlayerMoney(15);
		
		assertEquals("Money was increased by 15", 45, player.getMoney());
	}
	
	@Test 
	public void increasePlayerMoneyTest2(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(60);
		game.player = player;
		
		game.increasePlayerMoney(55);
		
		assertEquals("Money was increased by 55", 115, player.getMoney());
	}

	@Test
	public void gainBountyTest1(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(45);
		game.player = player;
		
		EnemyPoo poo = new EnemyPoo();
		game.enemyList.add(poo);
		game.gainBounty(0);
		
		assertEquals("Test Bounty gained from Poo", 55, player.getMoney());
	}
	
	@Test
	public void gainBountyTest2(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setMoney(105);
		game.player = player;
		
		EnemyPoo poo = new EnemyPoo();
		game.enemyList.add(poo);
		game.gainBounty(0);
		
		assertEquals("Test Bounty gained from Poo", 115, player.getMoney());
	}
	
	@Test
	public void isPlayerDeadTest1(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setHealth(50);
		game.player = player;
		boolean isDead = game.isPlayerDead();
		
		assertFalse("The player is not dead with a health of 50", isDead);
	}
	
	@Test
	public void isPlayerDeadTest2(){
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setHealth(0);
		game.player = player;
		boolean isDead = game.isPlayerDead();
		
		assertTrue("The player is dead with a health of 0", isDead);
	}
	
	@Test
	public void increaseScoreTest1() {
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setScore(2);
		game.player = player;
		game.increaseScore(2);
		
		assertEquals("Increasing the score of the player by 2", 4, player.getScore());
	}

	@Test
	public void increaseScoreTest2() {
		GameModel game = new GameModel();
		PlayerModel player = new PlayerModel();
		player.setScore(10);
		game.player = player;
		game.increaseScore(4);		
		
		assertEquals("Increasing the score of the player by 4", 14, player.getScore());
	}
}
