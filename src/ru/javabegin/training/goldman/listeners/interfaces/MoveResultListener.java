package ru.javabegin.training.goldman.listeners.interfaces;

import ru.javabegin.training.goldman.enums.ActionResult;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;

public interface MoveResultListener {
    
     public void notifyActionResult(ActionResult actionResult, AbstractGameObject sourceObject, AbstractGameObject targetObject);

}
