package controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Board;
import model.Music;
import model.Player;
import view.PlayGround;
import view.StartingGround;

public class Controller {
	private StartingGround starting;
	private PlayGround view;
	private Music music;
	private Board board;
	private Player player;

	public Controller(Board board, Player player, Music music) {
		super();
		this.board = board;
		this.player = player;
		this.music = music;

		starting = new StartingGround(this, music);
//		view = new PlayGround(this, music);

	}

	public void showView(int row, int column) {

		view = new PlayGround(this, board, player, music, row, column);

//    	view.setBoard(row,column);
	}

	public void turnMusic() {

		try {
			music.actionMusicBackground();
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

//	public void turnMusic() {
//		try {
//			music.turnOffMusicBackground();
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//
//	}

	public void offMusic() {
		try {
			music.turnOffMusicBackground();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		Music music = new Music();
		Board board = new Board();
		Player playingControll = new Player();
		Controller ctrl = new Controller(board, playingControll, music);

	}

	public void setArr(int i, int j) {
//	int[][] arrResult = board.getArr();
//	arrResult = new int[i][j];
		board.setArr(i, j);
	}

	public void setArrValue(int i, int j, int value) {
		// TODO Auto-generated method stub

		board.setArr(i, j, value);

	}
	public void setTurn() {
		// TODO Auto-generated method stub
		player.plusTurn();

	}

	public void setNameXO(String nameX, String nameO) {
		// TODO Auto-generated method stub
		player.setNameXO(nameX, nameO);
	}

}
