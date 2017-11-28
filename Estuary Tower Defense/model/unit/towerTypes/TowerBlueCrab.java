package unit.towerTypes;

import unit.TowerModel;

public class TowerBlueCrab extends TowerModel{

	public TowerBlueCrab(){
		setName("Blue Crab");
		setFactDescription("It's scientific name translates to 'Savory Beautiful Swimmer'");
		setGameDescription("Look out for his attack on small fish!");
		setxCor(1);
		setyCor(1);
		setReloadCount(0);
		setReloadTime(2);
		setDamage(50);
		setPrice(100);
		setRange(15);
		setUpgrade(null);
	
	}
}
