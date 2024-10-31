package ru.javabegin.training.goldman.gameobjects.impl;

import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;


/**
 * объект EXIT
 */
public class Exit extends AbstractGameObject {

    public Exit(Coordinate coordinate) {
        super.setType(GameObjectType.EXIT);
        super.setCoordinate(coordinate);
        super.saveIcon("/ru/javabegin/training/goldman/images/exit.gif");
    }
}
