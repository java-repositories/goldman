package ru.javabegin.training.goldman.creators;

import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;
import ru.javabegin.training.goldman.gameobjects.impl.Exit;
import ru.javabegin.training.goldman.gameobjects.impl.GoldMan;
import ru.javabegin.training.goldman.gameobjects.impl.Monster;
import ru.javabegin.training.goldman.gameobjects.impl.Nothing;
import ru.javabegin.training.goldman.gameobjects.impl.Treasure;
import ru.javabegin.training.goldman.gameobjects.impl.Tree;
import ru.javabegin.training.goldman.gameobjects.impl.Wall;

public class GameObjectCreator {

    private static GameObjectCreator instance;

    public static GameObjectCreator getInstance() {
        if (instance == null) {
            instance = new GameObjectCreator();
        }
        return instance;
    }

    private GameObjectCreator() {
    }

    public AbstractGameObject createObject(GameObjectType type, Coordinate coordinate) {
        AbstractGameObject obj = null;

        switch (type) {
            case NOTHING: {
                obj = new Nothing(coordinate);
                break;
            }
            case WALL: {
                obj = new Wall(coordinate);
                break;
            }
            case MONSTER: {
                obj = new Monster(coordinate);
                break;
            }
            case TREASURE: {
                obj = new Treasure(coordinate);
                break;
            }
            case EXIT: {
                obj = new Exit(coordinate);
                break;
            }

            case GOLDMAN: {
                obj = new GoldMan(coordinate);
                break;
            }
                
            case TREE:{
                obj = new Tree(coordinate);
                break;
            }

            default:
                throw new IllegalArgumentException("Can't create object type: " + type);

        }

        return obj;
    }
}
