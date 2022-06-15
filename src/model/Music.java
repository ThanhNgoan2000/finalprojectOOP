package model;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {
	private File file;
	private AudioInputStream audio;
	private AudioFormat format;
	private DataLine.Info info;
	public static Clip clip,pop;
	public static boolean musicBackground = false; // nhac
	public static boolean sound = false; // nhac
	public static boolean effor = false; // nhac effor
	public static int js1 = 0;//  music
	public static int js2 = 1;// effor music

	public Music(File file) {
		// TODO Auto-generated constructor stub
		this.file = file;
	}

	public void actionMusicbackGround()throws UnsupportedAudioFileException, IOException, LineUnavailableException  {

		audio = AudioSystem.getAudioInputStream(file);
		format = audio.getFormat();
		info = new DataLine.Info(Clip.class, format);
		clip = (Clip) AudioSystem.getLine(info);
		clip.open(audio);
		clip.addLineListener(new LineListener() {

			@Override
			public void update(LineEvent event) {
				// TODO Auto-generated method stub
				if (event.getType() == LineEvent.Type.STOP)
					;
				try {
					actionMusicbackGround();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}

		});

		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(js1);

		// sound == false thì chạy true thì ko đc chạy

				if (sound == false) {
					clip.start();
				}
	}

	public void backgroundMusic() {
		if(effor==false) {
			try {
				musicPop();
			} catch (UnsupportedAudioFileException| IOException|LineUnavailableException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		if (musicBackground ) {
             musicBackground = true;
             sound = true;
             clip.stop();
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
		gainControl.setValue(js2);
		pop.start();
	}
}
