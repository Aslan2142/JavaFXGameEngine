package sample;

import sample.Engine.BoxCollider3D;
import sample.Engine.Core.GameObject3D;
import sample.Engine.Core.Vector3D;

public class TestObject extends GameObject3D {

    public double moveAmount = 0;
    public BoxCollider3D collider;

    public TestObject()
    {
        super("/sample/untitled.obj");

        collider = new BoxCollider3D(this, 2, false);
        addComponent(collider);
    }

    @Override
    public void start() {

    }

    @Override
    public void update(double deltaTime) {
        Vector3D<Double> pos = getPosition();
        pos.x += moveAmount * deltaTime;

        if (!collider.collidesAtPosition(pos, false))
        {
            moveX(moveAmount * deltaTime);
        }
    }

    @Override
    public void collision(GameObject3D other) {
        System.out.println("this is a test");
    }

}