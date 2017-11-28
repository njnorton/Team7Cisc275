package unit.towerTypes;

import unit.TowerModel;

public class TowerRiverHerring extends TowerModel{

	public TowerRiverHerring(){
		setName("River Herring");
		setFactDescription("Iridescent fish with shades of Green and Violet, it's lucky to be here, less than 1 percent survive the journey to salt water!");
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
