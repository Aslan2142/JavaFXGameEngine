package sample;

import sample.Engine.Core.*;
import sample.Engine.ButtonObject;

public class MainMenuScene extends GameScene {

    public MainMenuScene()
    {
        ButtonObject startGameButton = new ButtonObject("Spustiť Hru", 160, 60, 60, 2);
        startGameButton.setFontSize(20);
        startGameButton.setPosition(20, 20);
        startGameButton.setOnMouseClicked(e -> Main.getSceneManager().setGameScene(new MainGameScene()));

        ButtonObject endGameButton = new ButtonObject("Ukončiť Hru", 160, 60, 60, 2);
        endGameButton.setFontSize(20);
        endGameButton.setPosition(20, 100);
        endGameButton.setOnMouseClicked(e -> System.exit(0));

        objects.add(startGameButton);
        objects.add(endGameButton);





        GameSubScene gameSubScene = new GameSubScene();

        Camera3D camera3D = new Camera3D();
        gameSubScene.setCamera(camera3D);

        GameObject3D obj = new GameObject3D("/sample/untitled.obj");
        obj.setScale(10, 10, 10);
        gameSubScene.add(obj);
        gameSubScene.add(camera3D);

        objects.add(gameSubScene);

    }

}
