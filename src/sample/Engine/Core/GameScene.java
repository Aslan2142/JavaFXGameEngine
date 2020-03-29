package sample.Engine.Core;

import java.util.ArrayList;
import java.util.List;

public abstract class GameScene {

    public Object args;

    public List<GameObject> objects = new ArrayList();
    public List<GameObject> newObjects = new ArrayList();

    public void addObject(GameObject gameObject)
    {
        newObjects.add(gameObject);
    }

}
