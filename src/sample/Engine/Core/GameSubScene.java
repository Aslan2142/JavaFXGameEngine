package sample.Engine.Core;

import javafx.scene.Group;
import javafx.scene.SceneAntialiasing;
import javafx.scene.SubScene;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class GameSubScene extends GameObject {

    public final Group root;
    public final List<GameObject> objects = new LinkedList<>();

    public GameSubScene()
    {
        super();

        root = new Group();
        node = new SubScene(root, 0, 0, true, SceneAntialiasing.BALANCED);
    }

    public final SubScene getSubScene()
    {
        return ((SubScene)node);
    }

    public final Group getRoot()
    {
        return ((Group)getSubScene().getRoot());
    }

    public final void add(GameObject gameObject)
    {
        gameObject.currentSubScene = this;
        objects.add(gameObject);
        getRoot().getChildren().add(gameObject.node);
    }

    public final void setCamera(Camera3D camera)
    {
        getSubScene().setCamera(camera.getCamera());
    }

    @Override
    public final void start() {
        for (GameObject obj : objects)
        {
            obj.start();
        }
    }

    @Override
    public final void update(double deltaTime) {
        Vector2D<Double> resolution = Main.getCurrentResolution();
        getSubScene().setWidth(resolution.x);
        getSubScene().setHeight(resolution.y);

        GameObject obj;

        Iterator<GameObject> iterator = objects.iterator();
        while (iterator.hasNext())
        {
            obj = iterator.next();

            if (!obj.isAlive())
            {
                iterator.remove();
                getRoot().getChildren().remove(obj.node);
                objects.remove(obj);
                continue;
            }
            obj.update(deltaTime);
            obj.componentUpdate(deltaTime);
        }
    }

}
