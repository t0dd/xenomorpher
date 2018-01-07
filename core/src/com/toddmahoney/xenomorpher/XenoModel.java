package com.toddmahoney.xenomorpher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class XenoModel {

    public World world;
    private Body bodyd;

    public XenoModel() {
        world = new World(new Vector2(0, -10f), true);
    }

    //game logic
    public void logicStep(float delta) {

        //tells Box2D world to move forward in time
        world.step(delta, 3, 3);
    }

    private void createObject() {

        //create a new Box2D body
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(0,0);

        // add it to the world
        bodyd = world.createBody(bodyDef);

        // set the shape (a box 50 meters wide, 1 meter tall )
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(1,1);

        // set the properties of the object ( shape, weight, restitution(bouncy-ness)
        // the data for a physical body part
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;

        // create the physical object in our body)
        // without this our body would just be data in the world
        bodyd.createFixture(shape, 0.0f);

        // we no longer use the shape object here so dispose of it.
        shape.dispose();
    }
}
