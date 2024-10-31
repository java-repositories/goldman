package ru.javabegin.training.goldman.gameobjects.impl;

import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;



public class Tree extends AbstractGameObject{
    public Tree(Coordinate coordinate) {
        super.setType(GameObjectType.TREE);
        super.setCoordinate(coordinate);
        super.saveIcon("/ru/javabegin/training/goldman/images/tree.jpg");
    }
}

