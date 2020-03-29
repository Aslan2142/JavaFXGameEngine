package sample.Engine.Core;

public class Version {

    private int major;
    private int minor;
    private int patch;

    public Version(int _major, int _minor, int _patch)
    {
        major = _major;
        minor = _minor;
        patch = _patch;
    }

    public Version(Version copy)
    {
        major = copy.major;
        minor = copy.minor;
        patch = copy.patch;
    }

    public int getMajor() {
        return major;
    }

    public int getMinor() {
        return minor;
    }

    public int getPatch() {
        return patch;
    }

}
