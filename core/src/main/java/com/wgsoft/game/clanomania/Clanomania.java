package com.wgsoft.game.clanomania;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
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

        for(final BitmapFont font: skin.getAll(BitmapFont.class).values()) {
            for(final TextureRegion region: font.getRegions()) {
                region.getTexture().setFilter(
                    Texture.TextureFilter.Linear,
                    Texture.TextureFilter.Linear
                );
            }
        }

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
