package unit.towerTypes;

import unit.TowerModel;

public class TowerSanderling extends TowerModel{

	public TowerSanderling(){
		setName("Sanderling");
		setFactDescription("Small plump birds that feed by sticking their bills deep in the sand, ");
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
