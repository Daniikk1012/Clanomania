package com.wgsoft.game.clanomania;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public final class Clanomania extends ApplicationAdapter {
    private SpriteBatch spriteBatch;
    private Texture texture;

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
        texture = new Texture(Gdx.files.internal("texture.png"));
    }

    @Override
    public void render() {
        ScreenUtils.clear(1f, 0f, 0f, 1f);

        spriteBatch.begin();
        spriteBatch.draw(texture, 0f, 0f);
        spriteBatch.end();
    }

    @Override
    public void dispose() {
        spriteBatch.dispose();
        texture.dispose();
    }
}
