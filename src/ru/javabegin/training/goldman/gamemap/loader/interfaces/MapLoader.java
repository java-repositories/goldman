package ru.javabegin.training.goldman.gamemap.loader.interfaces;

import java.util.ArrayList;
import ru.javabegin.training.goldman.objects.MapInfo;
import ru.javabegin.training.goldman.objects.SavedMapInfo;
import ru.javabegin.training.goldman.objects.User;

public interface MapLoader{
    
    boolean saveMap(SavedMapInfo mapInfo);
    
    boolean loadMap(MapInfo mapInfo);

    ArrayList<SavedMapInfo> getSavedMapList(User user);   
    
    boolean deleteSavedMap(MapInfo mapInfo);

}
