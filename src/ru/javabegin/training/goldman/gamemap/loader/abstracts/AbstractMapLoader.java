package ru.javabegin.training.goldman.gamemap.loader.abstracts;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import ru.javabegin.training.goldman.creators.GameObjectCreator;
import ru.javabegin.training.goldman.database.SQLiteConnection;
import ru.javabegin.training.goldman.enums.GameObjectType;
import ru.javabegin.training.goldman.gamemap.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.gamemap.loader.interfaces.MapLoader;
import ru.javabegin.training.goldman.gameobjects.abstracts.AbstractGameObject;
import ru.javabegin.training.goldman.gameobjects.impl.Coordinate;

public abstract class AbstractMapLoader implements MapLoader {

    protected AbstractGameMap gameMap;

    protected AbstractMapLoader(AbstractGameMap gameMap) {
        this.gameMap = gameMap;
    }

    protected void createGameObject(String str, Coordinate coordinate) {

        GameObjectType type = GameObjectType.valueOf(str.toUpperCase());


        AbstractGameObject newObj = GameObjectCreator.getInstance().createObject(type, coordinate);

        gameMap.getGameCollection().addGameObject(newObj);

        if (newObj.getType() == GameObjectType.EXIT) {
            gameMap.getMapInfo().setExitExist(true);
        } else if (newObj.getType() == GameObjectType.GOLDMAN) {
            gameMap.getMapInfo().setGoldManExist(true);
        }

    }

    public AbstractGameMap getGameMap() {
        return gameMap;
    }

    public int getPlayerId(String username) {

        PreparedStatement selectStmt = null;
        PreparedStatement insertStmt = null;
        ResultSet rs = null;

        try {

            // если есть уже такой пользователь - получить его id
            selectStmt = SQLiteConnection.getInstance().getConnection().prepareStatement("select id from player where username = ?");
            selectStmt.setString(1, username);

            rs = selectStmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1);
            }

            selectStmt.close();


            // если нет такого пользователя - создать его и вернуть id
            insertStmt = SQLiteConnection.getInstance().getConnection().prepareStatement("insert into player(username) values(?)");
            insertStmt.setString(1, username);
            insertStmt.executeUpdate();

            // получить id созданного пользователя
            selectStmt = SQLiteConnection.getInstance().getConnection().prepareStatement("select last_insert_rowid()");
            return selectStmt.executeQuery().getInt(1);

        } catch (SQLException ex) {
            Logger.getLogger(AbstractMapLoader.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {

                if (selectStmt != null) {
                    selectStmt.close();
                }
                if (insertStmt != null) {
                    insertStmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(AbstractMapLoader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return 0;
        
    }
}
