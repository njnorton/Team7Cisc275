package unit;
/**
 * An abstract class that contains attributes and methods that enemies and towers
 * will both have.
 * 
 * @author Ryan Barbera, Aaron George, Nick Norton, Thomas Pennington, Grant Zhao
 * 
 */

/*
 * Variable Dictionary:
 * String factDescription: a string that contains an educational message about the
 * 						   selected unit
 * String gameDescription: a string that contains a quick description about the
 * 						   selected unit
 * String name: a string that describes the name of the unit
 * int xCor: an integer that describes the x-coordinate of the unit
 * int yCor: an integer that describes the y-coordinate of the unit
 */
public abstract class UnitModel {
	
	String name;
	int xCor;
	int yCor;
	String gameDescription;
	String factDescription;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGameDescription() {
		return gameDescription;
	}

	public void setGameDescription(String gameDescription) {
		this.gameDescription = gameDescription;
	}

	public String getFactDescription() {
		return factDescription;
	}

	public void setFactDescription(String factDescription) {
		this.factDescription = factDescription;
	}
}
