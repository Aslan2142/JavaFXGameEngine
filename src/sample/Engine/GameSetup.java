package sample.Engine;

import sample.Engine.Core.GameScene;

public class GameSetup {

    public final String gameName = "Game";
    public final int majorVersion = 1;
    public final int minorVersion = 0;
    public final int patchVersion = 0;
    public final double targetFramerate = 60;
    public final int defaultResolutionX = 1280;
    public final int defaultResolutionY = 720;
    public final GameScene mainScene = new SomeScene();

}
