package model;

public class Player extends Observable {
     private String nameX = "";
     private String nameO = "";
     private int turn =1 ;

	public String getNameX() {
		return nameX;
	}
	public String getNameO() {
		return nameO;
	}
	public void setNameXO(String nameX, String nameO) {
		this.nameX = nameX;
		this.nameO = nameO;
//		System.out.println(namex+ " aa " + nameo);
		notifyObs();

	}
	public int getTurn() {
		// TODO Auto-generated method stub
		return turn;
	}
	public void plusTurn() {
		turn= 1- turn;
		System.out.println(" turn : " + turn);
		notifyObs();
	}



}
