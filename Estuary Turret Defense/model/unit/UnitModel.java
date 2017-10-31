package unit;

import java.awt.image.BufferedImage;

public abstract class UnitModel {
	String name;
	int xCor;
	int yCor;
	BufferedImage icon;
	String gameDescription;
	String factDescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = this.name;
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

	public BufferedImage geticon() {
		return icon;
	}

	public void setIcon(BufferedImage pooImage) {
		pooImage = this.icon;
	}

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		gameDescription = this.gameDescription;
	}

	public String getFactDescription() {
		return factDescription;
	}

	public void setFactDescription(String factDescription) {
		factDescription = this.factDescription;
	}
}
