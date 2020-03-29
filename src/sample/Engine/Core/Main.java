// Game Engine by Ján Trenčanský

package sample.Engine.Core;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;
import sample.Engine.GameSetup;

public class Main extends Application {

    private int engineVersionMajor = 1;
    private int engineVersionMinor = 0;
    private int engineVersionPatch = 0;

    private long currentTime;

    private static Scene scene;
    private ObservableList<Node> children;

    private GameSettings gameSettings;
    private GameScene gameScene;

    private static GameInfo gameInfo;
    private static SceneManager sceneManager;

    @Override
    public void start(Stage primaryStage) throws Exception {
        setupGame();

        Group root = new Group();
        children = root.getChildren();

        children.add(GameInput.getInstance());

        currentTime = System.nanoTime();
        KeyFrame keyFrame = new KeyFrame(Duration.millis(1000 / gameSettings.getTargetFramerate()), e -> update());
        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        Vector2D<Integer> resolution = gameSettings.getDefaultResolution();
        scene = new Scene(root, resolution.x, resolution.y);

        Version version = gameInfo.getGameVersion();
        primaryStage.setTitle(gameInfo.getGameName() + " - " + version.getMajor() + "." + version.getMinor() + "." + version.getPatch());
        primaryStage.setScene(scene);
        primaryStage.show();

        loadSceneObjects();
    }

    private void setupGame()
    {
        GameSetup gameSetup = new GameSetup();

        gameInfo = new GameInfo(
                gameSetup.gameName,
                new Version(gameSetup.majorVersion, gameSetup.minorVersion, gameSetup.patchVersion),
                new Version(engineVersionMajor, engineVersionMinor, engineVersionPatch)
        );

        gameSettings = new GameSettings(
                gameSetup.targetFramerate,
                new Vector2D(gameSetup.defaultResolutionX, gameSetup.defaultResolutionY)
        );

        sceneManager = new SceneManager(gameSetup.mainScene);
        gameScene = gameSetup.mainScene;

        GameInput.setup();
    }

    private void loadSceneObjects()
    {
        children.removeAll(gameScene.objects);
        gameScene = sceneManager.getGameScene();
        children.addAll(gameScene.objects);

        for (GameObject obj : gameScene.objects)
        {
            obj.start();
        }
    }

    private void loadNewSceneObjects()
    {
        for (GameObject obj : gameScene.newObjects)
        {
            obj.start();
        }

        children.addAll(gameScene.newObjects);
        gameScene.objects.addAll(gameScene.newObjects);
        gameScene.newObjects.clear();
    }

    private void update()
    {
        if (gameScene != sceneManager.getGameScene())
        {
            loadSceneObjects();
        }

        if (gameScene.newObjects.size() > 0)
        {
            loadNewSceneObjects();
        }

        long newTime = System.nanoTime();
        double deltaTime = (newTime - currentTime) / 1000000000d;
        currentTime = newTime;

        GameObject obj;
        for (int i = 0; i < gameScene.objects.size(); i++)
        {
            obj = gameScene.objects.get(i);
            if (!obj.isAlive())
            {
                children.remove(obj);
                gameScene.objects.remove(obj);
                i--;
                continue;
            }
            obj.update(deltaTime);
        }

        collisionUpdate();
    }

    private void collisionUpdate()
    {
        GameObject obj1;
        GameObject obj2;

        for (int i = 0; i < gameScene.objects.size(); i++)
        {
            obj1 = gameScene.objects.get(i);

            if (!obj1.collider || !obj1.isAlive())
            {
                continue;
            }

            for (int j = 0; j < gameScene.objects.size(); j++)
            {
                obj2 = gameScene.objects.get(j);

                if (i == j || !obj2.collider || !obj2.isAlive())
                {
                    continue;
                }

                if (obj1.getBoundsInParent().intersects(obj2.getBoundsInParent()))
                {
                    obj1.onCollision(obj2);
                }
            }
        }
    }

    public static void main(String[] args)
    {
        launch(args);
    }

    public static GameInfo getGameInfo()
    {
        return new GameInfo(gameInfo);
    }

    public static SceneManager getSceneManager()
    {
        return sceneManager;
    }

    public static Vector2D<Double> getCurrentResolution()
    {
        return new Vector2D<>(scene.getWidth(), scene.getHeight());
    }

}
