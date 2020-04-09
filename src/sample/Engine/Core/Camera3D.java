package sample.Engine.Core;

import javafx.scene.Camera;
import javafx.scene.PerspectiveCamera;

public class Camera3D extends GameObject3D {

    public Camera3D()
    {
        node = new PerspectiveCamera(true);
        getCamera().setNearClip(0.01);
        getCamera().setFarClip(10000);
    }

    public Camera3D(double nearClip, double farClip)
    {
        node = new PerspectiveCamera(true);
        getCamera().setNearClip(nearClip);
        getCamera().setFarClip(farClip);
    }

    public Camera getCamera()
    {
        return ((Camera)node);
    }

    @Override
    public void start() {

    }

    @Override
    public void update(double deltaTime) {

    }

}
