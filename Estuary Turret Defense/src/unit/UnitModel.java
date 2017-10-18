package unit;

import java.awt.image.BufferedImage;

public abstract class UnitModel {
	String Name;
	int xCor;
	int yCor;
	BufferedImage[] Icon;
	String GameDescription;
	String FactDescription;
	
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
	public int getxCor() {
		return xCor;
	}
	public void setxCor(int xCor) {
		this.xCor = xCor;
	}
	public int getyCor() {
		return yCor;
	}
	public void setyCor(int yCor) {
		this.yCor = yCor;
	}
	public BufferedImage[] getIcon() {
		return Icon;
	}
	public void setIcon(BufferedImage[] icon) {
		Icon = icon;
	}
	public String getGameDescription() {
		return GameDescription;
	}
	public void setGameDescription(String gameDescription) {
		GameDescription = gameDescription;
	}
	public String getFactDescription() {
		return FactDescription;
	}
	public void setFactDescription(String factDescription) {
		FactDescription = factDescription;
	}
}
