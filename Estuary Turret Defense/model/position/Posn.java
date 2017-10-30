package position;

public class Posn {

	int xCor;
	int yCor;
	
	public Posn(int xC, int yC) {
		xCor = xC;
		yCor = yC;
	}
	
	public int getX() {
		return xCor;
	}
	public void setX(int xC) {
		xCor = xC;
	}
	public void moveX(int speed) {
		xCor += speed;
	}
	
	public int getY() {
		return yCor;
	}
	public void setY(int yC) {
		yCor = yC;
	}
	public void moveY(int speed) {
		yCor += speed;
	}
	
}
