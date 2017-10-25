package unit.turret.turrettypes;

import java.awt.image.BufferedImage;

import enums.ShellfishEnum;
import unit.turret.TurretModel;

public class TurretCrab extends TurretModel {
	
	BufferedImage turrcrab;
	
	public TurretCrab(){
		setName("Crab");
		setFactDescription("Blue Crab are indigenous to the region");
		setGameDescription("Look out for his big meaty claws!");
		setIcon(null);
		setxCor(1);
		setyCor(1);
		setReloadCount(0);
		setReloadTime(2);
		setDamage(50);
		setPrice(100);
		setRange(15);
		setUpgrade(null);
	}
	
	public void setCoordinates(int x, int y){
		this.setxCor(x);
		this.setyCor(y);
	}
}
