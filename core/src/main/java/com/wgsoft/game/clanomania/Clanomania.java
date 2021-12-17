package com.wgsoft.game.clanomania;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;

public final class Clanomania extends ApplicationAdapter {
    private SpriteBatch spriteBatch;

    private Skin skin;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();

        skin = new Skin(Gdx.files.internal("img/skin.json"));
    }

    @Override
    public void render() {
        ScreenUtils.clear(1f, 0f, 0f, 1f);

        spriteBatch.begin();
        spriteBatch.draw(skin.getRegion("texture"), 0f, 0f);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();

        skin.dispose();
    }
}
