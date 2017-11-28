package main;

import java.util.ArrayList;
import unit.EnemyModel;
import unit.TowerModel;
import unit.towerTypes.TowerGenericShellfish;
import unit.towerTypes.TowerGenericBird;
import unit.towerTypes.TowerGenericFish;

public class GameModel {

	public ArrayList<EnemyModel> enemyList;
	public ArrayList<TowerModel> towerList;
	public ArrayList<EnemyModel> enemyModelList;
	public ArrayList<TowerModel> towerModelList;
	public PathModel path;
	public Factory factory;
	public PlayerModel player;
	

	public GameModel() {
		enemyList = new ArrayList<EnemyModel>();
		towerList = new ArrayList<TowerModel>();
		enemyModelList = new ArrayList<EnemyModel>(7);
		towerModelList = new ArrayList<TowerModel>(12);
		fillTowerModelList();
		fillEnenmyModelList();
		path = new PathModel();
		factory = new Factory();
		player = new PlayerModel();
		
		
	}
	
	private void fillEnenmyModelList() {
		// TODO Auto-generated method stub
		
	}

	//TODO finish this
	private void fillTowerModelList() {
		for(int counter = 0; counter < 12; counter++) {
			switch(counter) {
				case 0 :
					towerModelList.add(new TowerGenericBird());
					break;
					
				case 4 :
					towerModelList.add(new TowerGenericFish());
					break;
					
				case 8 :
					towerModelList.add(new TowerGenericShellfish());
					break;
					
				default:
					break;
			}
		}
	}

	// Sees if the Reload Count for a tower is zero, if it is it returns true
	// (it can fire)
	// If it is not zero, reduce the tower's reload count by 1, and return false
	public boolean isReloading(int towerInd) {
		if (towerList.get(towerInd).getReloadCount() == 0)
			return false;
		else {
			towerList.get(towerInd).setReloadCount(towerList.get(towerInd).getReloadCount() - 1);
			return true;
		}
	}

	public void resetReload(int towerInd) {
		towerList.get(towerInd).setReloadCount(towerList.get(towerInd).getReloadTime());
	}

	// Checks the range of the tower versus the enemy, if it is range it returns
	// true
	// If it is not in range it returns false
	public boolean isInRange(int towerInd, int enemyInd) {
		System.out.println("Try Check Range");
		int xDis = towerList.get(towerInd).getxCor() - enemyList.get(enemyInd).getxCor();
		int yDis = towerList.get(towerInd).getyCor() - enemyList.get(enemyInd).getyCor();
		double Dis = Math.sqrt(Math.pow(xDis, 2) + Math.pow(yDis, 2));

		if (Dis > towerList.get(towerInd).getRange())
			return true;
		else
			return false;
	}

	// adds damage to the current object that is on the game
	public void damageEnemy(int towerInd, int enemyInd) {
		enemyList.get(enemyInd)
				.setCurrentHealth(enemyList.get(enemyInd).getCurrentHealth() - towerList.get(towerInd).getDamage());
		System.out.println("Current baddie health: " + enemyList.get(enemyInd).getCurrentHealth());

		if (0 >= enemyList.get(enemyInd).getCurrentHealth())
			enemyList.remove(enemyInd);
	}

	// Moves the enemy forward, removing it if it falls out of bound
	// if it is removed via falling out of bound, return true
	public void moveEnemy(int enemyInd) {
		int moveInd = enemyList.get(enemyInd).getPositionIndex() + enemyList.get(enemyInd).getSpeed();
		enemyList.get(enemyInd).setxCor(path.getxCorAtIndex(moveInd));
		enemyList.get(enemyInd).setyCor(path.getyCorAtIndex(moveInd));
		enemyList.get(enemyInd).setPositionIndex(moveInd);

	}

	public boolean isOutOfBounds(int enemyInd) {
		if (enemyList.get(enemyInd).getPositionIndex() >= path.getSize())
			return true;
		else
			return false;
	}

	// spawns an enemy onto the game
	public void spawnEnemy() {
		int rand1 = (int)Math.random() % 7 + 1;
		EnemyModel enemy = factory.makeEnemy(rand1);
		enemy.setxCor(path.getxCorAtIndex(0));
		enemy.setxCor(path.getyCorAtIndex(0));
		enemyList.add(enemy);
	}

	// spawns a tower on a given xCor yCor
	public void spawnTower(String towerName, int xCor, int yCor) {
		TowerModel tower = factory.makeTower(towerName);
		tower.setxCor(path.getxCorAtIndex(xCor));
		tower.setyCor(path.getyCorAtIndex(yCor));
		towerList.add(tower);
	}

	// Checks the price of the tower, returning true if the player can afford it
	// or false if he cannot
	// TODO alter it so it doesn't have to make a tower to check price
	public boolean isAffordable(String towerName) {
		TowerModel tower = factory.makeTower(towerName);
		if (player.getMoney() >= tower.getPrice()) {
			return true;
		} else {
			return false;
		}
	}

	// Reduce the player's health by the given amount
	public void reducePlayerHealth(int i) {
		player.setHealth(player.getHealth() - i);
	}

	// Reduce the player's money by the given amount
	public void reducePlayerMoney(int i) {
		player.setMoney(player.getMoney() - i);
	}

	// Increase the player's money by the given amount
	public void increasePlayerMoney(int i) {
		player.setMoney(player.getMoney() + i);
	}

	// gain an amount of money equal to the bounty value of the enemy
	public void gainBounty(int enemyInd) {
		increasePlayerMoney(enemyList.get(enemyInd).getBounty());
	}

	// Checks the players health, if false they are dead
	public boolean isPlayerDead() {
		if (player.getHealth() > 0) {
			return false;
		} else {
			return true;
		}
	}

	// Increase the players score by a given amount
	// Then return the player's score
	public void increaseScore(int inc) {
		player.setScore(player.getScore() + inc);
	}
}
