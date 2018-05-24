package game;

import java.io.BufferedInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class sounds {
	
	public static soundplayer pupsound;
	public static soundplayer coinsound;
	public static soundplayer mdead;
	public static soundplayer ecrush;
	public static soundplayer jmpsound;
	public static soundplayer bricksh;
	public static soundplayer bump;
	public static soundplayer gosound;
	public static soundplayer levelsound;
	
	public sounds(){
		pupsound=new soundplayer("/sound/power_up.wav");
		coinsound=new soundplayer("/sound/coin.wav");
		mdead=new soundplayer("/sound/mariodead.wav");
		ecrush=new soundplayer("/sound/ecrush.wav");
		jmpsound=new soundplayer("/sound/jump.wav");
		bricksh=new soundplayer("/sound/brickshatter.wav");
		bump=new soundplayer("/sound/bump.wav");
		levelsound=new soundplayer("/music/levelm.wav");
		 gosound=new soundplayer("/sound/gameover.wav");
		
	
	}

	 class soundplayer {
		private Clip clip;
		private FloatControl control;
		
		public soundplayer(String path){
			try{
				InputStream audiosrc=getClass().getResourceAsStream(path);
				InputStream bufferedIn=new BufferedInputStream(audiosrc);
				AudioInputStream ais=AudioSystem.getAudioInputStream(bufferedIn);
				AudioFormat baseformat=ais.getFormat();
				AudioFormat decodeFormat=new AudioFormat(AudioFormat.Encoding.PCM_SIGNED,baseformat.getSampleRate(),16,baseformat.getChannels(),baseformat.getChannels()*2,baseformat.getSampleRate(),false);
				
				AudioInputStream dais=AudioSystem.getAudioInputStream(decodeFormat,ais);
				clip=AudioSystem.getClip();
				clip.open(dais);
				control=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
				
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
		public void play(){
			if(clip==null){
				return;
			}
			stop();
			clip.setFramePosition(0);
			
				clip.start();
			
		}
		
		public void stop(){
			if(clip.isRunning()){
				clip.stop();
			}
		}
		public void close(){
			stop();
			clip.drain();
			clip.close();
		}
		
		public void loop(){
			clip.loop(Clip.LOOP_CONTINUOUSLY);
			while(!clip.isRunning()){
				clip.start();
			}
		}
		
		public void setVolume(float value){
			control.setValue(value);
		}
	}
}
