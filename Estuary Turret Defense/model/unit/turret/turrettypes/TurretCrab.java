package unit.turret.turrettypes;

import unit.turret.TurretModel;

public class TurretCrab extends TurretModel{
	public TurretCrab() {
		setName("Generic Crab");
		setFactDescription("TBD");
		setGameDescription("TBD");
		setIcon(null);
		setReloadCount(0);
		setReloadTime(2);
		setDamage(50);
		setPrice(150);
		setRange(15);
		setUpgrade(null);
	}
	public void setCoordinates(int x, int y) {
		this.setxCor(x);
		this.setyCor(y);
	}
}
