package com.wgsoft.game.clanomania;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.wgsoft.game.clanomania.screen.GameScreen;

public final class Clanomania extends Game {
    private SpriteBatch spriteBatch;

    private Skin skin;

    private GameScreen gameScreen;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        skin = new Skin(Gdx.files.internal("img/skin.json"));

        gameScreen = new GameScreen(this);

        setScreen(gameScreen);
    }

    @Override
    public void render() {
        ScreenUtils.clear(Color.BLACK);

        super.render();
    }

    @Override
    public void dispose() {
        super.dispose();

        spriteBatch.dispose();

        skin.dispose();

        gameScreen.dispose();
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public Skin getSkin() {
        return skin;
    }
}
