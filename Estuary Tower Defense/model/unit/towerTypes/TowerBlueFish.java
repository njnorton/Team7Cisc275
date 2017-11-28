package unit.towerTypes;

import unit.TowerModel;

public class TowerBlueFish extends TowerModel{

	public TowerBlueFish(){
		setName("Blue Fish");
		setFactDescription("Fierce fish with sharp teeth for feeding, he gets a mean reputation");
		setGameDescription("Look out for his attack on small fish!");
		setxCor(1);
		setyCor(1);
		setReloadCount(0);
		setReloadTime(3);
		setDamage(45);
		setPrice(90);
		setRange(12);
		setUpgrade(null);
	}
}
