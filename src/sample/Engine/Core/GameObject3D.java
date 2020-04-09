package sample.Engine.Core;

import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;

public class GameObject3D extends GameObject {

    public GameObject3D()
    {
        super();

        TriangleMesh mesh = new TriangleMesh();

        float h = 150;                    // Height
        float s = 300;                    // Side
        mesh.getPoints().addAll(
                0,    0,    0,            // Point 0 - Top
                0,    h,    -s/2,         // Point 1 - Front
                -s/2, h,    0,            // Point 2 - Left
                s/2,  h,    0,            // Point 3 - Back
                0,    h,    s/2           // Point 4 - Right
        );

        mesh.getTexCoords().addAll(0,0);

        mesh.getFaces().addAll(
                0,0,  2,0,  1,0,          // Front left face
                0,0,  1,0,  3,0,          // Front right face
                0,0,  3,0,  4,0,          // Back right face
                0,0,  4,0,  2,0,          // Back left face
                4,0,  1,0,  2,0,          // Bottom rear face
                4,0,  3,0,  1,0           // Bottom front face
        );

        node = new MeshView(mesh);
        ((MeshView)node).setMaterial(new PhongMaterial(Color.BLUE));
        ((MeshView)node).setCullFace(CullFace.BACK);
    }

    @Override
    public void start() {
        setPosition(0, 0, 1000);
    }

    @Override
    public void update(double deltaTime) {
        //rotate(0.3, 0.8, 0.1);
    }

    public final void setX(double value)
    {
        node.setTranslateX(value);
    }

    public final void setY(double value)
    {
        node.setTranslateY(value);
    }

    public final void setZ(double value)
    {
        node.setTranslateZ(value);
    }

    public final void setPosition(double posX, double posY, double posZ)
    {
        setX(posX);
        setY(posY);
        setZ(posZ);
    }

    public final void setPosition(Vector3D<Double> value)
    {
        setPosition(value.x, value.y, value.z);
    }

    public final double getX()
    {
        return node.getTranslateX();
    }

    public final double getY()
    {
        return node.getTranslateY();
    }

    public final double getZ()
    {
        return node.getTranslateZ();
    }

    public final Vector3D<Double> getPosition()
    {
        return new Vector3D(getX(), getY(), getZ());
    }

    public final void move(double deltaX, double deltaY, double deltaZ)
    {
        setX(getX() + deltaX);
        setY(getY() + deltaY);
        setZ(getZ() + deltaZ);
    }

    public final void move(Vector3D<Double> delta)
    {
        move(delta.x, delta.y, delta.z);
    }

    public final void moveInVector(double deltaX, double deltaY, double deltaZ, double amount)
    {
        move(deltaX * amount, deltaY * amount, deltaZ * amount);
    }

    public final void moveInVector(Vector3D<Double> delta, double amount)
    {
        move(delta.x * amount, delta.y * amount, delta.z * amount);
    }

    public final void setRotationX(double value)
    {
        setRotation(value, Rotate.X_AXIS);
    }

    public final void setRotationY(double value)
    {
        setRotation(value, Rotate.Y_AXIS);
    }

    public final void setRotationZ(double value)
    {
        setRotation(value, Rotate.Z_AXIS);
    }

    public final void setRotation(double value, Point3D axis)
    {
        Rotate rotate = new Rotate(value, axis);
        node.getTransforms().clear();
        node.getTransforms().add(rotate);
    }

    public final void setRotation(double valueX, double valueY, double valueZ)
    {
        setRotationX(valueX);
        setRotationY(valueY);
        setRotationZ(valueZ);
    }

    public final void setRotation(Vector3D<Double> value)
    {
        setRotation(value.x, value.y, value.z);
    }

    public final void rotateX(double value)
    {
        rotate(value, Rotate.X_AXIS);
    }

    public final void rotateY(double value)
    {
        rotate(value, Rotate.Y_AXIS);
    }

    public final void rotateZ(double value)
    {
        rotate(value, Rotate.Z_AXIS);
    }

    public final void rotate(double value, Point3D axis)
    {
        if (node.getTransforms().size() == 0)
        {
            setRotation(0, 0, 0);
        }

        Rotate rotate = new Rotate(value, axis);
        Transform transform = node.getTransforms().get(0);
        transform = transform.createConcatenation(rotate);
        node.getTransforms().clear();
        node.getTransforms().add(transform);
    }

    public final void rotate(double valueX, double valueY, double valueZ)
    {
        rotateX(valueX);
        rotateY(valueY);
        rotateZ(valueZ);
    }

    public final void rotate(Vector3D<Double> value)
    {
        rotate(value.x, value.y, value.z);
    }

    public final void setScaleX(double value)
    {
        node.setScaleX(value);
    }

    public final void setScaleY(double value)
    {
        node.setScaleY(value);
    }

    public final void setScaleZ(double value)
    {
        node.setScaleZ(value);
    }

    public final void setScale(double scaleX, double scaleY, double scaleZ)
    {
        setScaleX(scaleX);
        setScaleY(scaleY);
        setScaleZ(scaleZ);
    }

    public final void setScale(Vector3D<Double> value)
    {
        setScale(value.x, value.y, value.z);
    }

    public final double getScaleX()
    {
        return node.getScaleX();
    }

    public final double getScaleY()
    {
        return node.getScaleY();
    }

    public final double getScaleZ()
    {
        return node.getScaleZ();
    }

    public final Vector3D<Double> getScale()
    {
        return new Vector3D(getScaleX(), getScaleY(), getScaleZ());
    }

    public final void setOnMouseClicked(EventHandler<? super MouseEvent> e)
    {
        node.setOnMouseClicked(e);
    }

}