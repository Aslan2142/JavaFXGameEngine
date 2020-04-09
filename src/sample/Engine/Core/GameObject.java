package sample.Engine.Core;

import javafx.scene.Node;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject {

    public String name;
    public Node node;

    protected boolean alive;

    public GameObject()
    {
        name = "";
        alive = true;
    }

    public void start() {}

    public void update(double deltaTime) {}

    public final void destroy()
    {
        alive = false;
    }

    public final boolean isAlive()
    {
        return alive;
    }

    public final GameScene getCurrentScene()
    {
        return Main.getSceneManager().getGameScene();
    }

    public final GameObject getGameObject(String _name)
    {
        GameScene currentScene = getCurrentScene();

        for (GameObject obj : currentScene.objects)
        {
            if (obj.name == _name)
            {
                return obj;
            }
        }

        return null;
    }

    public final List<GameObject> getGameObjects(String _name)
    {
        GameScene currentScene = getCurrentScene();
        List<GameObject> gameObjects = new ArrayList<>();

        for (GameObject obj : currentScene.objects)
        {
            if (obj.name == _name)
            {
                gameObjects.add(obj);
            }
        }

        return gameObjects;
    }

    public final void addToScene(GameObject gameObject)
    {
        Main.getSceneManager().getGameScene().addObject(gameObject);
    }

}
