package unit.turret;

import unit.UnitModel;

public abstract class TurretModel extends UnitModel {
	int range;
	int damage;
	int price;
	
	//TODO Turrets should have attack methods at this level
	
	//HOW THIS WORKS reloadTime is how long it takes for something to fire
	//reloadCount is the current reload counter, every time tick it is reduced by 1
	//When reloadCount is 0, the turret can fire again
	int reloadTime;
	int reloadCount;
	
	//The possible turrets it can upgrade into
	String[] upgrade;
	
	public int getRange() {
		return range;
	}
	public void setRange(int range) {
		this.range = range;
	}
	public int getDamage() {
		return damage;
	}
	public void setDamage(int damage) {
		this.damage = damage;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getReloadTime() {
		return reloadTime;
	}
	public void setReloadTime(int reloadTime) {
		this.reloadTime = reloadTime;
	}
	public int getReloadCount() {
		return reloadCount;
	}
	public void setReloadCount(int reloadCount) {
		this.reloadCount = reloadCount;
	}
	public String[] getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(String[] upgrade) {
		this.upgrade = upgrade;
	}
}
