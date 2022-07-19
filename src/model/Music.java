package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
//	private File file;
//	private AudioInputStream audio;
//	private AudioFormat format;
//	private DataLine.Info info;
	private  Clip clip, pop;
	public static boolean musicBackground = false; // nhac
	public static boolean sound = false; // nhac
	public static int js1 = 0;// music


	public Music() {
		// TODO Auto-generated constructor stub

	}
// background music
	public void actionMusicBackground()
			throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("music/backgound.wav");
		AudioInputStream audio;
		audio = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audio);
		clip.start();
		clip.loop(Clip.LOOP_CONTINUOUSLY);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(js1);

	}
	public void turnOffMusicBackground() {
		clip.stop();
	}

	public void  checkbackgroundMusic() {

		if (musicBackground==false) {
			musicBackground = true;
			sound = true;
			clip.stop();
		}else
		if (musicBackground==true) {
			musicBackground = false;
			sound = false;

//			PlayGround.mute.setToolTipText("turn off music");
		}
	}

	public void musicPop() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		File file = new File("sound/pop.wav");
		AudioInputStream audio = AudioSystem.getAudioInputStream(file);
		AudioFormat format = audio.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		pop = (Clip) AudioSystem.getLine(info);
		pop.open(audio);
		FloatControl gainControl = (FloatControl) pop.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(js1);
		pop.start();
	}
}
