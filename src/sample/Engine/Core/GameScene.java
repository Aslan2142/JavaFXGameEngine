package sample.Engine.Core;
import java.util.LinkedList;
import java.util.List;

public abstract class GameScene {

    public Object args;

    public List<GameObject> objects = new LinkedList();
    public List<GameObject> newObjects = new LinkedList();

    public void addObject(GameObject gameObject)
    {
        newObjects.add(gameObject);
    }

}
