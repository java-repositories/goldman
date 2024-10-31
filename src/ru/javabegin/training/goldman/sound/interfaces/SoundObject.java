package ru.javabegin.training.goldman.sound.interfaces;

import javax.sound.sampled.Clip;
import ru.javabegin.training.goldman.enums.ActionResult;

public interface SoundObject {

    Clip getSoundClip(ActionResult actionResult);
    
}
