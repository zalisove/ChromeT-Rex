package sample;

import javax.sound.sampled.*;
import java.io.IOException;


public class GameMusic {

    private static AudioInputStream jump;
    private static AudioInputStream death;
    private static AudioInputStream backgroundMusic;


    public static void jump(){

        try {
            jump = AudioSystem.getAudioInputStream(Main.class.getResource("res/jump.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(jump);
            clip.setFramePosition(0);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }
    public static void death(){

        try {
            death = AudioSystem.getAudioInputStream(Main.class.getResource("res/dier.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(death);
            clip.setFramePosition(0);
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }
    public static Clip backgroundMusic(){
        Clip clip = null;
        try {
            backgroundMusic = AudioSystem.getAudioInputStream(Main.class.getResource("res/relaxxx1.wav"));
            clip = AudioSystem.getClip();
            clip.open(backgroundMusic);
            clip.setFramePosition(0);
            clip.isRunning();
            clip.start();
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return clip;
    }
}
