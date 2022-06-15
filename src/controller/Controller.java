package controller;

import java.io.File;
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
public Controller() {
	super();
	starting = new StartingGround();
	view = new PlayGround(15, 15);

	music = new Music(new File("music/backgound.wav"));
}
public void showStarting() {

}
   public void showView() {
	view.setVisible(true);
}
   public void turnMusic()  {


	  try {
		  music.actionMusicbackGround();
	} catch ( IOException | LineUnavailableException | UnsupportedAudioFileException  e) {
		// TODO: handle exception
		e.printStackTrace();
	}

   }
}

