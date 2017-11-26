package unit.towerTypes;

import unit.TowerModel;

public class TowerGenericFish extends TowerModel{

	public TowerGenericFish(){
		setName("Generic Fish");
		setFactDescription("White Perch are found in numerous counts in Delaware Estuaries");
		setGameDescription("Look out for me swimming in the Delaware Bay!");
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
