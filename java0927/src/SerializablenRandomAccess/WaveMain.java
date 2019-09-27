package SerializablenRandomAccess;

import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class WaveMain {

	public static void main(String[] args) {
		try {
			/*
			//로컬파일의 URL
			URL url = new URL("file://///Users/a503-22/Documents/pottery_workshop.wav "
					);
			AudioClip audio =
					Applet.newAudioClip(url);
			audio.play();
		*/
			
		Player player = 
				new Player(
						new FileInputStream(
						"/Users/a503-22/Documents/Twinkle.mp3"));
		
		player.play();
		
		// mp3재생은 javafx 패키지의 MediaPlayer클래스로도 가능 
		
		/* 
		javafx.scene.Media m =
				 new avafx.scene.Media("파일경로")
		MediaPlayer p = new MediaPlayer(m); 
		p.play(); 		 
		*/
		
		} catch(Exception e) {
			System.out.printf("%s\n", e.getMessage());
		}

	}

}
