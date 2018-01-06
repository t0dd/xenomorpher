package com.toddmahoney.xenomorpher;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class XenoModel {
    public World world;

    public XenoModel() {
        world = new World(new Vector2(0, -10f), true);
    }

    //game logic
    public void logicStep(float delta) {

        //tells Box2D world to move forward in time
        world.step(delta, 3, 3);
    }
}
