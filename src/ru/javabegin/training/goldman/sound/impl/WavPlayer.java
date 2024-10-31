package ru.javabegin.training.goldman.sound.impl;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultListener;
import ru.javabegin.training.goldman.sound.interfaces.SoundObject;
import ru.javabegin.training.goldman.sound.interfaces.SoundPlayer;

public class WavPlayer implements MoveResultListener, SoundPlayer {

    public static final String SOUND_BACKGROUND = "background.wav";
    public static final String SOUND_DIE = "die.wav";
    public static final String SOUND_TREASURE = "treasure.wav";
    public static final String SOUND_WIN = "win.wav";
    public static final String SOUND_MOVE = "waka_waka.wav";
    public static final String SOUND_TREE = "tree.wav";
    
    public static final String SOUND_PATH = "/ru/javabegin/training/goldman/sound/files/";
    private Clip backGroundClip;
    
    public WavPlayer() {

        AudioInputStream ais = null;
        try {
            backGroundClip = AudioSystem.getClip();
            ais = AudioSystem.getAudioInputStream(this.getClass().getResource(WavPlayer.SOUND_PATH + SOUND_BACKGROUND));
            backGroundClip.open(ais);

        } catch (UnsupportedAudioFileException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (LineUnavailableException ex) {
            Logger.getLogger(WavPlayer.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void startBackgroundMusic(String soundName) {
        playSound(backGroundClip, true);
    }

    @Override
    public void stopBackgoundMusic() {
        if (backGroundClip != null && backGroundClip.isRunning()) {
            backGroundClip.stop();
        }

    }

    @Override
    public void notifyActionResult(ActionResult actionResult, final AbstractGameObject abstractMovingObject, final AbstractGameObject targetObject) {

        if (!(abstractMovingObject instanceof SoundObject)) {
            return;
        }


        SoundObject soundObject = (SoundObject) abstractMovingObject;

        Clip clip = soundObject.getSoundClip(actionResult);

        playSound(clip, false);

    }

    @Override
    public void playSound(final Clip clip, final boolean loop) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                if (clip == null) {
                    return;
                }

                clip.setFramePosition(0);
                
                if (loop) {
                    clip.loop(Clip.LOOP_CONTINUOUSLY);
                } else {
                    if (clip.isRunning()) {
                        clip.stop();
                    }
                    
                    clip.start();
                }


            }
        });
        
        thread.setDaemon(true);       
        thread.start();


    }
    
    
}
