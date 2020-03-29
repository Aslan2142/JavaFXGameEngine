package sample.Engine;

import sample.Engine.Core.GameScene;

public class GameSetup {

    public String gameName = "Game";
    public int majorVersion = 1;
    public int minorVersion = 0;
    public int patchVersion = 0;
    public double targetFramerate = 60;
    public int defaultResolutionX = 1280;
    public int defaultResolutionY = 720;
    public GameScene mainScene = new SomeScene();

}
