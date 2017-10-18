package turret;

public abstract class TurretModel {
	int range;
	int damage;
	int attackSpeed;
	int price;
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
	public int getAttackSpeed() {
		return attackSpeed;
	}
	public void setAttackSpeed(int attackSpeed) {
		this.attackSpeed = attackSpeed;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String[] getUpgrade() {
		return upgrade;
	}
	public void setUpgrade(String[] upgrade) {
		this.upgrade = upgrade;
	}
}
