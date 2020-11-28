package sample;

import javax.sound.sampled.*;
import java.io.IOException;


public class GameMusic {
    private Clip jumpClip;
    private Clip deathClip;
    private Clip backgroundMusicClip;


    public GameMusic() {
        AudioInputStream jump;
        AudioInputStream death;
        AudioInputStream backgroundMusic;
        try {
            jump = AudioSystem.getAudioInputStream(Main.class.getResource("res/jump.wav"));
            jumpClip = AudioSystem.getClip();
            jumpClip.open(jump);

            death = AudioSystem.getAudioInputStream(Main.class.getResource("res/dier.wav"));
            deathClip = AudioSystem.getClip();
            deathClip.open(death);

            backgroundMusic = AudioSystem.getAudioInputStream(Main.class.getResource("res/relaxxx1.wav"));
            backgroundMusicClip = AudioSystem.getClip();
            backgroundMusicClip.open(backgroundMusic);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }


    }

    public  void jump(){

            jumpClip.setFramePosition(0);
            jumpClip.start();

    }
    public  void death(){

        deathClip.setFramePosition(0);
        deathClip.start();


    }
    public  void backgroundMusic(){


            backgroundMusicClip.setFramePosition(0);
            backgroundMusicClip.start();
            backgroundMusicClip.loop(Clip.LOOP_CONTINUOUSLY);

    }
}
