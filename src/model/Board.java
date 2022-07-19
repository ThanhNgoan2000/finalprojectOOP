package model;


public class Board extends Observable{
  private int[][] arr;
  private boolean[][] tick;
 static  int count = 0;
public int[][] getArr() {
	return arr;
}
public void setArr(int i,int j) {
	arr = new int[i][j];
	notifyObs();
}
public void setArr(int i, int j, int value) {
	arr[i][j] = value;
	notifyObs();
}



}
