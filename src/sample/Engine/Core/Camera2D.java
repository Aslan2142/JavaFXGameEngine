package sample.Engine.Core;

import javafx.scene.Camera;
import javafx.scene.ParallelCamera;

public class Camera2D extends GameObject2D {

    public Camera2D()
    {
        super(0, 0);

        node = new ParallelCamera();
    }

    public Camera getCamera()
    {
        return ((Camera)node);
    }

}
