package controller;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import model.Music;
import view.PlayGround;
import view.StartingGround;

public class Controller {
	private StartingGround starting;
	private PlayGround view;
	private Music music;

	public Controller(Music music) {
		super();
		this.music = music;
		starting = new StartingGround(this,music);
//		view = new PlayGround(this, music);

	}

    public void showView(int row, int column) {
    	view = new PlayGround(this, music,row,column);
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
			Controller ctrl = new Controller(music);
}
}
