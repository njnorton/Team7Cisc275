package unit.towerTypes;

import unit.TowerModel;

public class TowerRuddyTurnstone extends TowerModel{

	public TowerRuddyTurnstone(){
		setName("Ruddy Turnstone");
		setFactDescription("Calico Colored shorebird that looks for food by flipping rocks and pebbles. They migrate in groups of 10 to over 1000");
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
