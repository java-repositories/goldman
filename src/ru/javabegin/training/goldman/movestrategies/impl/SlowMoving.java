package ru.javabegin.training.goldman.movestrategies.impl;

import java.util.Random;
import ru.javabegin.training.goldman.collections.interfaces.GameCollection;
import ru.javabegin.training.goldman.enums.MovingDirection;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractMovingObject;
import ru.javabegin.training.goldman.movestrategies.interfaces.MoveStrategy;

public class SlowMoving implements MoveStrategy {
    

    @Override
    public MovingDirection getDirection(AbstractMovingObject movingObject, AbstractGameObject targetObject, GameCollection gameCollection) {

        MovingDirection direction = null;

        int characterX = targetObject.getCoordinate().getX();
        int characterY = targetObject.getCoordinate().getY();

        int monsterX = movingObject.getCoordinate().getX();
        int monsterY = movingObject.getCoordinate().getY();

        int number = getRandomInt(2);// 50% шанс чтобы двинуться к игроку
        // может сгенерить 1 или 0. это и будет 50% шанса
        if (number == 1) { // 0 - двигаться по направлению к игроку
            // наугад берется любое направление к игроку
            number = getRandomInt(2);
            switch (number) {// двигаться по оси X в сторону игрока или по оси Y
                case 1: {
                    if (monsterX > characterX) {
                        direction = MovingDirection.LEFT;
                    } else {
                        direction = MovingDirection.RIGHT;
                    }
                    break;
                }
                case 2: {
                    if (monsterY > characterY) {
                        direction = MovingDirection.UP;
                    } else {
                        direction = MovingDirection.DOWN;
                    }
                    break;
                }

            }
        } else { // 1 - двигаться по направлению от игрока
            number = getRandomInt(2);
            switch (number) {// двигаться по оси X от игрока или по оси Y
                case 1: {
                    if (monsterX > characterX) {
                        direction = MovingDirection.RIGHT;
                    } else {
                        direction = MovingDirection.LEFT;
                    }
                    break;
                }
                case 2: {
                    if (monsterY > characterY) {
                        direction = MovingDirection.DOWN;
                    } else {
                        direction = MovingDirection.UP;
                    }
                    break;
                }
            }
        }


        return direction;
    }

    private int getRandomInt(int i) {
        Random r = new Random();
        return r.nextInt(i) + 1;
    }
}
