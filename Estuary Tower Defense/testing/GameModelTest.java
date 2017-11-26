import static org.junit.Assert.*;

import org.junit.Test;

import main.GameModel;

public class GameModelTest extends GameModel {
	
	@Test
	public void spawnEnemyTest(){
		GameModel game = new GameModel();
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		game.path.setxCorArr(xCoord);
		game.path.setyCorArr(yCoord);
		
		game.spawnEnemy("EnemyPoo");
		assertEquals("Test enemy creation", "EnemyPoo", game.enemyList.get(0).getName());
	}
	
	@Test
	public void spawnTowerTest(){
		GameModel game = new GameModel();
		
		int[] xCoord = {0,1};
		int[] yCoord = {0,1};
		
		game.path.setxCorArr(xCoord);
		game.path.setyCorArr(yCoord);
				
		game.spawnTower("Crab", game.path.getxCorAtIndex(1), game.path.getyCorAtIndex(1));
				
		assertEquals("Test Crab tower name check","Crab", game.towerList.get(0).getName());
		assertEquals("Test Crab x Coordinate", 1, game.towerList.get(0).getxCor());
		assertEquals("Test Crab y Coordinate", 1, game.towerList.get(0).getyCor());
	}
	
	//TODO tests for isAffordable once method is fixed 
	
	@Test 
	public void reducePlayerHealthTest1(){
		GameModel game = new GameModel();
		
		game.player.setHealth(30);
		game.reducePlayerHealth(5);
		
		assertEquals("Health was reduced by 5", 25, game.player.getHealth());
	}
	
	@Test 
	public void reducePlayerHealthTest2(){
		GameModel game = new GameModel();
		
		game.player.setHealth(30);
		game.reducePlayerHealth(25);
		
		assertEquals("Health was reduced by 25", 5, game.player.getHealth());
	}
	
	@Test 
	public void reducePlayerMoneyTest1(){
		GameModel game = new GameModel();
		
		game.player.setMoney(30);
		game.reducePlayerMoney(14);
		
		assertEquals("Money was reduced by 14", 16, game.player.getMoney());
	}
	
	@Test 
	public void reducePlayerMoneyTest2(){
		GameModel game = new GameModel();
		
		game.player.setMoney(50);
		game.reducePlayerMoney(10);
		
		assertEquals("Money was reduced by 10", 40, game.player.getMoney());
	}
	
	@Test 
	public void increasePlayerMoneyTest1(){
		GameModel game = new GameModel();
		
		game.player.setMoney(30);
		game.increasePlayerMoney(15);
		
		assertEquals("Money was increased by 15", 45, game.player.getMoney());
	}
	
	@Test 
	public void increasePlayerMoneyTest2(){
		GameModel game = new GameModel();
		
		game.player.setMoney(60);
		game.increasePlayerMoney(55);
		
		assertEquals("Money was increased by 55", 115, game.player.getMoney());
	}

	//TODO test gain bounty when the classes are defined 
	
	@Test
	public void isPlayerDeadTest1(){
		GameModel game = new GameModel();
		
		game.player.setHealth(50);
		boolean isDead = game.isPlayerDead();
		
		assertFalse(isDead);
	}
	
	@Test
	public void isPlayerDeadTest2(){
		GameModel game = new GameModel();
		
		game.player.setHealth(0);
		boolean isDead = game.isPlayerDead();
		
		assertTrue(isDead);
	}
	
	@Test
	public void increaseScoreTest1() {
		GameModel game = new GameModel();
		
		game.player.setScore(2);
		game.increaseScore(2);
		
		assertEquals("Increasing the score of the player by 2", 4, game.player.getScore());
	}

	@Test
	public void increaseScoreTest2() {
		GameModel game = new GameModel();
		
		game.player.setScore(10);
		game.increaseScore(4);
		
		assertEquals("Increasing the score of the player by 4", 14, game.player.getScore());
	}
}
