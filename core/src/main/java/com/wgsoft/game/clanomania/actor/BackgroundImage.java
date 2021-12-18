package com.wgsoft.game.clanomania.actor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.wgsoft.util.MutableFloat;

public final class BackgroundImage extends Image {
    private static final int OFFSET_X = 3;
    private static final int OFFSET_Y = 1;

    private static final float DURATION = 20f;

    public BackgroundImage(final Skin skin) {
        super(skin, "background-image");

        setColor(skin.getColor("background-image"));

        final TextureRegion region = ((TiledDrawable)getDrawable()).getRegion();

        final MutableFloat offsetX =
            new MutableFloat(region.getRegionWidth() * OFFSET_Y);
        final MutableFloat offsetY =
            new MutableFloat(region.getRegionHeight() * OFFSET_X);

        addAction(Actions.forever(Actions.run(() -> {
            setSize(
                getStage().getWidth() + offsetX.value,
                getStage().getHeight() + offsetY.value
            );
        })));

        addAction(Actions.forever(Actions.sequence(
            Actions.moveTo(-offsetX.value, -offsetY.value),
            Actions.moveTo(0f, 0f, DURATION)
        )));
    }
}
