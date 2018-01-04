package com.toddmahoney.xenomorpher.views;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.toddmahoney.xenomorpher.Xenomorpher;
import com.badlogic.gdx.scenes.scene2d.Stage;

public class MenuScreen implements Screen {

    private Stage stage;
    private Xenomorpher parent;

    public MenuScreen(Xenomorpher xenomorpher) {
        parent = xenomorpher;
        stage = new Stage(new ScreenViewport());
        //this tells the screen to send any input from the user to the stage so it can respond
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {
        //create a table that fills the screen
        //everything else will go inside this table
        Table table = new Table();
        table.setFillParent(true);
        table.setDebug(true);
        stage.addActor(table);

        //Create buttons
        Skin skin = new Skin(Gdx.files.internal("skin/quantum-horizon-ui.json"));
        TextButton newGame = new TextButton("NEW GAME", skin);
        TextButton preferences = new TextButton("PREFERENCES", skin);
        TextButton exit = new TextButton("EXIT", skin);

        //add buttons to table
        table.add(newGame).fillX().uniformX();
        table.row().pad(10, 0, 10, 0);
        table.add(preferences).fillX().uniformX();
        table.row();
        table.add(exit).fillX().uniformX();

        //button listeners
        exit.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                Gdx.app.exit();
            }
        });
        newGame.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Xenomorpher.APPLICATION);
            }
        });
        preferences.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                parent.changeScreen(Xenomorpher.PREFERENCES);
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // tell the stage to do stuff and draw itself
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        //this tells the stage the screen size has changed and the viewport should be recalculated
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
