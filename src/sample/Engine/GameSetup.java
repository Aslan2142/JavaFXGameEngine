package sample.Engine;

import sample.Engine.Core.GameScene;

public class GameSetup {

    public final String gameName = "Pacman 3D";
    public final int majorVersion = 0;
    public final int minorVersion = 9;
    public final int patchVersion = 9;
    public final double targetFramerate = 60;
    public final int defaultResolutionX = 1280;
    public final int defaultResolutionY = 720;
    public final GameScene mainScene = new StartScene();

}
