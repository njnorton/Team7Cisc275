//package model.main;
//
//import static org.junit.Assert.*;
//
//import org.junit.Test;
//
//import main.GameModel;
//
//public class GameModelTest extends GameModel {	
//	@Test
//	public void isReloadingTest1(){
//		GameModel game = new GameModel();
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnTower("Blue Crab", game.path.getxCorAtIndex(0), game.path.getyCorAtIndex(0));
//		game.spawnTower("Blue Crab", game.path.getxCorAtIndex(1), game.path.getyCorAtIndex(1));
//		
//		boolean isLoading = game.isReloading(0);
//		
//		assertFalse("Tower Crab at index 0 is reloading",isLoading);
//	}
//	
//	//TODO need one more reload test to go here 
//	
//	@Test
//	public void resetReloadTest1(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnTower("Blue Crab", game.path.getxCorAtIndex(0), game.path.getyCorAtIndex(0));
//		
//		game.resetReload(0);
//		
//		assertEquals("Test to see if reload time is equal to 2", 2, game.blueCrab.getReloadTime());
//	}
//	
//	@Test
//	public void damageEnemyTest1(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		game.spawnTower("Generic Fish", game.path.getxCorAtIndex(0), game.path.getyCorAtIndex(0));
//		game.damageEnemy(0, 0);
//	
//		assertEquals("Test damage health against enemy", 105, game.enemyList.get(0).getCurrentHealth());
//	}
//	
//	@Test
//	public void moveEnemyTest1(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1,2,3,4,5};
//		int[] yCoord = {0,1,2,3,4,5};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.moveEnemy(0);
//		
//		assertEquals("Test position index moved 5", 5, game.enemyList.get(0).getPositionIndex());
//	}
//	
//	@Test
//	public void moveEnemyTest2(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,13,22,33,44,55};
//		int[] yCoord = {0,21,32,23,34,15};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.spawnEnemy("Poo");
//		game.moveEnemy(1);
//		
//		assertEquals("Test position index moved 5", 5, game.enemyList.get(1).getPositionIndex());
//	}
//	
//	@Test 
//	public void isOutOfBoundsTest1(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		
//		boolean bounds = game.isOutOfBounds(0);
//		
//		assertTrue("Enemy is within bounds", bounds);
//	}
//	
//	@Test 
//	public void isOutOfBoundsTest2(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		game.path.setSize(3);
//		game.spawnEnemy("Poo");
//		
//		boolean bounds = game.isOutOfBounds(0);
//		
//		assertFalse("Enemy is not within bounds", bounds);
//	}
//	
//	@Test
//	public void spawnEnemyTest(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		assertEquals("Test enemy creation", "EnemyPoo", game.enemyList.get(0).getName());
//		assertEquals("Test EnemyPoo x coordinate", 0, game.enemyList.get(0).getxCor());
//		assertEquals("Test EnemyPoo y coordinate", 0, game.enemyList.get(0).getyCor());
//	}
//	
//	@Test
//	public void spawnTowerTest(){
//		GameModel game = new GameModel();
//		
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//				
//		game.spawnTower("Generic Bird", game.path.getxCorAtIndex(1), game.path.getyCorAtIndex(1));
//				
//		assertEquals("Test Crab tower name check","Generic Bird", game.towerList.get(0).getName());
//		assertEquals("Test Crab x Coordinate", 1, game.towerList.get(0).getxCor());
//		assertEquals("Test Crab y Coordinate", 1, game.towerList.get(0).getyCor());
//	}
//	
//	//TODO tests for isAffordable once method is fixed 
//	
//	@Test 
//	public void reducePlayerHealthTest1(){
//		GameModel game = new GameModel();
//		
//		game.player.setHealth(30);
//		game.reducePlayerHealth(5);
//		
//		assertEquals("Health was reduced by 5", 25, game.player.getHealth());
//	}
//	
//	@Test 
//	public void reducePlayerHealthTest2(){
//		GameModel game = new GameModel();
//		
//		game.player.setHealth(30);
//		game.reducePlayerHealth(25);
//		
//		assertEquals("Health was reduced by 25", 5, game.player.getHealth());
//	}
//	
//	@Test 
//	public void reducePlayerMoneyTest1(){
//		GameModel game = new GameModel();
//		
//		game.player.setMoney(30);
//		game.reducePlayerMoney(14);
//		
//		assertEquals("Money was reduced by 14", 16, game.player.getMoney());
//	}
//	
//	@Test 
//	public void reducePlayerMoneyTest2(){
//		GameModel game = new GameModel();
//		
//		game.player.setMoney(50);
//		game.reducePlayerMoney(10);
//		
//		assertEquals("Money was reduced by 10", 40, game.player.getMoney());
//	}
//	
//	@Test 
//	public void increasePlayerMoneyTest1(){
//		GameModel game = new GameModel();
//		
//		game.player.setMoney(30);
//		game.increasePlayerMoney(15);
//		
//		assertEquals("Money was increased by 15", 45, game.player.getMoney());
//	}
//	
//	@Test 
//	public void increasePlayerMoneyTest2(){
//		GameModel game = new GameModel();
//		
//		game.player.setMoney(60);
//		game.increasePlayerMoney(55);
//		
//		assertEquals("Money was increased by 55", 115, game.player.getMoney());
//	}
//
//	@Test
//	public void gainBountyTest1(){
//		GameModel game = new GameModel();
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		game.player.setMoney(45);
//		game.gainBounty(0);
//		
//		assertEquals("Test Bounty gained from Poo", 55, game.player.getMoney());
//	}
//	
//	@Test
//	public void gainBountyTest2(){
//		GameModel game = new GameModel();
//		int[] xCoord = {0,1};
//		int[] yCoord = {0,1};
//		
//		game.path.setxCorArr(xCoord);
//		game.path.setyCorArr(yCoord);
//		
//		game.spawnEnemy("Poo");
//		game.player.setMoney(105);
//		game.gainBounty(0);
//		
//		assertEquals("Test Bounty gained from Poo", 115, game.player.getMoney());
//	}
//	
//	@Test
//	public void isPlayerDeadTest1(){
//		GameModel game = new GameModel();
//		
//		game.player.setHealth(50);
//		boolean isDead = game.isPlayerDead();
//		
//		assertFalse(isDead);
//	}
//	
//	@Test
//	public void isPlayerDeadTest2(){
//		GameModel game = new GameModel();
//		
//		game.player.setHealth(0);
//		boolean isDead = game.isPlayerDead();
//		
//		assertTrue(isDead);
//	}
//	
//	@Test
//	public void increaseScoreTest1() {
//		GameModel game = new GameModel();
//		
//		game.player.setScore(2);
//		game.increaseScore(2);
//		
//		assertEquals("Increasing the score of the player by 2", 4, game.player.getScore());
//	}
//
//	@Test
//	public void increaseScoreTest2() {
//		GameModel game = new GameModel();
//		
//		game.player.setScore(10);
//		game.increaseScore(4);
//		
//		assertEquals("Increasing the score of the player by 4", 14, game.player.getScore());
//	}
//}
