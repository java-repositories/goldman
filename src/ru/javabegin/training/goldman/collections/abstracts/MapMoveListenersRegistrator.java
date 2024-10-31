package ru.javabegin.training.goldman.collections.abstracts;

import java.util.ArrayList;
import java.util.List;
import ru.javabegin.training.goldman.collections.interfaces.GameCollection;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultListener;
import ru.javabegin.training.goldman.listeners.interfaces.MoveResultNotifier;

public abstract class MapMoveListenersRegistrator implements GameCollection, MoveResultNotifier{

    private ArrayList<MoveResultListener> listeners = new ArrayList<>();

    @Override
    public List<MoveResultListener> getMoveListeners() {
        return listeners;
    }

    @Override
    public void addMoveListener(MoveResultListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeMoveListener(MoveResultListener listener) {
        listeners.remove(listener);
    }

    @Override
    public void removeAllMoveListeners() {
        listeners.clear();
    }

}
