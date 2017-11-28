package unit.towerTypes;

import unit.TowerModel;

public class TowerOsprey extends TowerModel{

	public TowerOsprey(){
		setName("Osprey");
		setFactDescription("Slender sea hawk that eats fish and nests around saltmarshes, river, and ponds. They have no teeth!");
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
