package ru.javabegin.training.goldman.gamemap.interfaces;

import java.awt.Component;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;

public interface DrawableMap extends MainMap{
    
    Component getMapComponent();
    
    boolean updateMap();
    
    void updateMapObjects(AbstractGameObject obj1, AbstractGameObject obj2);

}
