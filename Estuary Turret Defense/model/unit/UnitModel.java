package unit;

import java.awt.image.BufferedImage;
import position.Posn;

public abstract class UnitModel {
	String name;
	//2D Position
	Posn posn;
	int xCor;
	int yCor;
	BufferedImage[] icon;
	String gameDescription;
	String factDescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		name = this.name;
	}
	
	//2D Position
	public Posn getPosn() {
		return posn;
	}
	public void setPosn(Posn posn) {
		this.posn = posn;
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

	public BufferedImage[] geticon() {
		return icon;
	}

	public void setIcon(BufferedImage[] icon) {
		icon = this.icon;
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
