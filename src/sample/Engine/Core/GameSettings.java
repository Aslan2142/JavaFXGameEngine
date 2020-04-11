package sample.Engine.Core;

public class GameSettings {

    private final double targetFramerate;
    private final Vector2D<Integer> defaultResolution;

    public GameSettings(double _targetFramerate, Vector2D<Integer> _defaultResolution)
    {
        targetFramerate = _targetFramerate;
        defaultResolution = _defaultResolution;
    }

    public double getTargetFramerate() {
        return targetFramerate;
    }

    public Vector2D<Integer> getDefaultResolution()
    {
        return defaultResolution;
    }

}
