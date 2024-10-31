package ru.javabegin.training.goldman.gameobjects.impl;

import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;


/**
 * класс отвечает за работу объекта WALL
 */
public class Wall extends AbstractGameObject{

    public Wall(Coordinate coordinate) {
        super.setType(GameObjectType.WALL);
        super.setCoordinate(coordinate);        
        super.saveIcon("/ru/javabegin/training/goldman/images/wall.png");
    }
}
