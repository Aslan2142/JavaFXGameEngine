package sample.Engine.Core;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.ArrayList;
import java.util.List;

public abstract class GameObject extends Canvas {

    public String name;
    public boolean collider;

    private boolean alive;

    protected GraphicsContext context;

    public GameObject(double sizeX, double sizeY)
    {
        super(sizeX, sizeY);

        context = getGraphicsContext2D();

        collider = false;
        alive = true;
    }

    public void start() {}

    public void update(double deltaTime) {}

    public void onCollision(GameObject other) {}

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

    public final Vector2D<Double> getFacingDirection()
    {
        double rotation = getRotate() % 360;
        rotation = rotation < 0 ? 360 + rotation : rotation;
        rotation = Math.toRadians(rotation);

        return new Vector2D(-Math.sin(rotation), Math.cos(rotation));
    }

    public final void setPosition(Vector2D<Double> position)
    {
        setPosition(position.x, position.y);
    }

    public final void setPosition(double x, double y)
    {
        setLayoutX(x);
        setLayoutY(y);
    }

    public final Vector2D<Double> getPosition()
    {
        return new Vector2D<>(getLayoutX(), getLayoutY());
    }

    public final void move(Vector2D<Double> deltaPosition)
    {
        move(deltaPosition.x, deltaPosition.y);
    }

    public final void move(double deltaX, double deltaY)
    {
        setLayoutX(getLayoutX() + deltaX);
        setLayoutY(getLayoutY() + deltaY);
    }

    public final void moveInDirection(double direction, double amount)
    {
        direction = direction % 360;
        direction = direction < 0 ? 360 + direction : direction;
        direction = Math.toRadians(direction);

        setLayoutX(getLayoutX() + -Math.sin(direction) * amount);
        setLayoutY(getLayoutY() + Math.cos(direction) * amount);
    }

}
