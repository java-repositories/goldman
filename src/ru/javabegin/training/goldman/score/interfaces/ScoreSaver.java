package ru.javabegin.training.goldman.score.interfaces;

import java.util.ArrayList;
import ru.javabegin.training.goldman.objects.UserScore;

public interface ScoreSaver{
    
    boolean saveScore(UserScore userScore);

    ArrayList<UserScore> getScoreList();   

}
