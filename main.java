package sound;

import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.UnsupportedAudioFileException;


public class main {
	
	public static Mixer mixer;
	public static Clip clip;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Mixer.Info[] mixInfos = AudioSystem.getMixerInfo();
		URL soundUrl;
		AudioInputStream audioStream;
		DataLine.Info dataInfo;
		
		for(Mixer.Info info : mixInfos) {
			System.out.println(info.getName() + "-------" + info.getDescription());
		}

		try {
			soundUrl = main.class.getResource("/sound/1900.wav");
			audioStream = AudioSystem.getAudioInputStream(soundUrl);
			mixer = AudioSystem.getMixer(mixInfos[0]);
			dataInfo = new DataLine.Info(Clip.class, null);
			clip = (Clip)mixer.getLine(dataInfo);
			clip.open(audioStream);
		}catch (LineUnavailableException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}catch (UnsupportedAudioFileException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		
		
		clip.start();
		
		do {
			
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
		} while (clip.isActive());
	}

}
