package sample.Engine;

import sample.Engine.Core.GameScene;
import sample.Engine.Core.Main;
import sample.MainMenuScene;

public class StartScene extends GameScene {

    @Override
    public void start() {
        Main.getSceneManager().setGameScene(new MainMenuScene());
    }

}
