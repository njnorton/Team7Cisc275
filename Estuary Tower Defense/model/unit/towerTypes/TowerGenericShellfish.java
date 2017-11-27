package unit.towerTypes;

import unit.TowerModel;

public class TowerGenericShellfish extends TowerModel {
	public TowerGenericShellfish() {
		setName("Generic Shellfish");
		setFactDescription("Shellfish are indigenous to the region");
		setGameDescription("Look out for his ????");
		setxCor(1);
		setyCor(1);
		setReloadCount(0);
		setReloadTime(2);
		setDamage(50);
		setPrice(100);
		setRange(15);
		setUpgrade(null);
	}

	public void setCoordinates(int x, int y) {
		this.setxCor(x);
		this.setyCor(y);
	}
}
