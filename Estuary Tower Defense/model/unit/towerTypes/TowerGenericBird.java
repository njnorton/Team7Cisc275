package unit.towerTypes;

import unit.TowerModel;

public class TowerGenericBird extends TowerModel{

	public TowerGenericBird(){
		setName("Generic Bird");
		setFactDescription("Birds eat the small fish in the estuaries");
		setGameDescription("Look out for his attack on small fish!");
		setxCor(1);
		setyCor(1);
		setReloadCount(0);
		setReloadTime(3);
		setDamage(30);
		setPrice(110);
		setRange(17);
		setUpgrade(null);
	}
}
