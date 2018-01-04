package com.toddmahoney.xenomorpher.views;

import com.badlogic.gdx.Screen;
import com.toddmahoney.xenomorpher.Xenomorpher;

public class LoadingScreen implements Screen {

    private Xenomorpher parent;

    public LoadingScreen(Xenomorpher game) {
        parent = game;
        System.out.println("Loading Screen");
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        parent.changeScreen(Xenomorpher.MENU);
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
