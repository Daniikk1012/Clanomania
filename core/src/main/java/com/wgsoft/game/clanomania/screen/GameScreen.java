package com.wgsoft.game.clanomania.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.wgsoft.game.clanomania.Clanomania;
import com.wgsoft.game.clanomania.Constants;
import com.wgsoft.game.clanomania.actor.Background;
import com.wgsoft.game.clanomania.actor.game.Clan;

public final class GameScreen extends ScreenAdapter {
    private final Stage stage;

    public GameScreen(final Clanomania game) {
        stage = new Stage(new ScreenViewport(), game.getSpriteBatch());

        stage.addActor(new Background(game.getSkin()));

        final HorizontalGroup clans = new HorizontalGroup();
        clans.setFillParent(true);
        clans.space(32f);

        for(final Clan.ClanColor color: Clan.ClanColor.values()) {
            clans.addActor(new Clan(color.toString(), game.getSkin(), color));
        }

        final ScrollPane scrollPane = new ScrollPane(clans);
        scrollPane.setFillParent(true);
        stage.addActor(scrollPane);

        stage.setScrollFocus(scrollPane);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(final float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(final int width, final int height) {
        ((ScreenViewport)stage.getViewport()).setUnitsPerPixel(
            width * Constants.SCREEN_HEIGHT > Constants.SCREEN_WIDTH * height
                ? Constants.SCREEN_HEIGHT / height
                : Constants.SCREEN_WIDTH / width
        );
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
