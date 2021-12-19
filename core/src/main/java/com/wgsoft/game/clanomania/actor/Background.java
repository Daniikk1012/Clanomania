package com.wgsoft.game.clanomania.actor;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.WidgetGroup;
import com.badlogic.gdx.scenes.scene2d.utils.TiledDrawable;
import com.wgsoft.util.MutableFloat;

public final class Background extends WidgetGroup {
    private static final int OFFSET_X = 3;
    private static final int OFFSET_Y = 1;

    private static final float DURATION = 20f;

    public Background(final Skin skin) {
        setFillParent(true);

        final Image backgroundPixel = new Image(skin, "background-pixel");
        backgroundPixel.setFillParent(true);
        addActor(backgroundPixel);

        final Image backgroundImage = new Image(skin, "background-image");
        backgroundImage.setColor(skin.getColor("background-image"));

        final TextureRegion region =
            ((TiledDrawable)backgroundImage.getDrawable()).getRegion();

        final MutableFloat offsetX =
            new MutableFloat(region.getRegionWidth() * OFFSET_Y);
        final MutableFloat offsetY =
            new MutableFloat(region.getRegionHeight() * OFFSET_X);

        backgroundImage.addAction(Actions.forever(Actions.run(() -> {
            backgroundImage.setSize(
                getWidth() + offsetX.value,
                getHeight() + offsetY.value
            );
        })));

        backgroundImage.addAction(Actions.forever(Actions.sequence(
            Actions.moveTo(-offsetX.value, -offsetY.value),
            Actions.moveTo(0f, 0f, DURATION)
        )));

        addActor(backgroundImage);
    }
}
