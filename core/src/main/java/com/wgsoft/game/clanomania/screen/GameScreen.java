package com.wgsoft.game.clanomania.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.wgsoft.game.clanomania.Clanomania;
import com.wgsoft.game.clanomania.Constants;
import com.wgsoft.game.clanomania.actor.BackgroundImage;

public final class GameScreen extends ScreenAdapter {
    private final Stage stage;

    public GameScreen(final Clanomania game) {
        stage = new Stage(new ScreenViewport(), game.getSpriteBatch());

        final Image backgroundPixel =
            new Image(game.getSkin(), "background-pixel");
        backgroundPixel.setFillParent(true);
        stage.addActor(backgroundPixel);

        stage.addActor(new BackgroundImage(game.getSkin()));
    }

    @Override
    public void render(final float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(final int width, final int height) {
        ((ScreenViewport)stage.getViewport()).setUnitsPerPixel(
            Constants.SCREEN_WIDTH * height > width * Constants.SCREEN_HEIGHT
                ? Constants.SCREEN_HEIGHT / height
                : Constants.SCREEN_WIDTH / width
        );
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
