package main;


public class PathModel {
	int[] xCorArr;
	int[] yCorArr;
	int size;
	
	public int[] getxCorArr() {
		return xCorArr;
	}
	public void setxCorArr(int[] xCorArr) {
		this.xCorArr = xCorArr;
	}
	public int[] getyCorArr() {
		return yCorArr;
	}
	public void setyCorArr(int[] yCorArr) {
		this.yCorArr = yCorArr;
	}
	public int getSize() {
		return size;
	}
	
	public int getxCorAtIndex(int ind){
		return xCorArr[ind];
	}
	
	public int getyCorAtIndex(int ind){
		return yCorArr[ind];
	}
	
	public void setSize(int size) {
		this.size = size;
	}

	
}
