package ru.javabegin.training.goldman.gamemap.adapters;

import java.util.ArrayList;
import ru.javabegin.training.goldman.enums.LocationType;
import ru.javabegin.training.goldman.gamemap.abstracts.AbstractGameMap;
import ru.javabegin.training.goldman.gamemap.loader.impl.DBMapLoader;
import ru.javabegin.training.goldman.gamemap.loader.impl.FSMapLoader;
import ru.javabegin.training.goldman.objects.MapInfo;
import ru.javabegin.training.goldman.objects.SavedMapInfo;
import ru.javabegin.training.goldman.objects.User;

public class HybridMapLoader {
    
    private DBMapLoader dBMapLoader;
    private FSMapLoader fSMapLoader;

    private AbstractGameMap gameMap;
    
    public HybridMapLoader(AbstractGameMap gameMap) {
        dBMapLoader = new DBMapLoader(gameMap);
        fSMapLoader = new FSMapLoader(gameMap);
        this.gameMap = gameMap;
    }
    
    
    
    public boolean saveMap(SavedMapInfo mapInfo, LocationType locationType){
        switch (locationType){
            case DB:{
                return dBMapLoader.saveMap(mapInfo);
            }
                
            case FS:{
                return fSMapLoader.saveMap(mapInfo);
            }
        }
        
        return false;
    }
    
    public boolean loadMap(MapInfo mapInfo, LocationType locationType){
        switch (locationType){
            case DB:{
                gameMap = dBMapLoader.getGameMap();
                return dBMapLoader.loadMap(mapInfo);
            }
                
            case FS:{
                gameMap = fSMapLoader.getGameMap();
                return fSMapLoader.loadMap(mapInfo);
            }
        }
        
        
        
        return false;
    }

    public ArrayList<SavedMapInfo> getSavedMapList(User user, LocationType locationType){
        switch (locationType){
            case DB:{
                return dBMapLoader.getSavedMapList(user);
            }
                
            case FS:{
                return fSMapLoader.getSavedMapList(user);
            }
        }
        
        return null;
    }
    
    public boolean deleteSavedMap(MapInfo mapInfo, LocationType locationType){
        switch (locationType){
            case DB:{
                return dBMapLoader.deleteSavedMap(mapInfo);
            }
                
            case FS:{
                return fSMapLoader.deleteSavedMap(mapInfo);
            }
        }
        
        return false;
    }

    public AbstractGameMap getGameMap() {
        return gameMap;
    }

    
    public int getPlayerId(String username){
        return dBMapLoader.getPlayerId(username);        
    }

}
