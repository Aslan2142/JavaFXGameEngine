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

        TestObject obj1 = new TestObject(); obj1.setPosition(2, 1.5, 10); obj1.moveAmount = -0.05;
        TestObject obj2 = new TestObject(); obj2.setPosition(-2, 1.5, 10); obj2.moveAmount = 0.05;
        gameSubScene.add(obj1);
        gameSubScene.add(obj2);
        gameSubScene.add(camera3D);

        objects.add(gameSubScene);

    }

}
