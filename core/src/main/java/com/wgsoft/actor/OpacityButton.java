package com.wgsoft.actor;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.utils.Null;
import com.wgsoft.util.MutableBoolean;

public final class OpacityButton extends Button {
    private static final float PRESSED_OPACITY = 0.5f;
    private static final float DURATION = 0.125f;

    public OpacityButton() {
        super();
        initialize();
    }

    public OpacityButton(final Actor child, final Button.ButtonStyle style) {
        super(child, style);
        initialize();
    }

    public OpacityButton(final Actor child, final Skin skin) {
        super(child, skin);
        initialize();
    }

    public OpacityButton(
        final Actor child,
        final Skin skin,
        final String styleName
    ) {
        super(child, skin, styleName);
        initialize();
    }

    public OpacityButton(final Button.ButtonStyle style) {
        super(style);
        initialize();
    }

    public OpacityButton(@Null final Drawable up) {
        super(up);
        initialize();
    }

    public OpacityButton(@Null final Drawable up, @Null final Drawable down) {
        super(up, down);
        initialize();
    }

    public OpacityButton(
        @Null final Drawable up,
        @Null final Drawable down,
        @Null final Drawable checked
    ) {
        super(up, down, checked);
        initialize();
    }

    public OpacityButton(final Skin skin) {
        super(skin);
        initialize();
    }

    public OpacityButton(final Skin skin, final String styleName) {
        super(skin, styleName);
        initialize();
    }

    private void initialize() {
        final MutableBoolean wasPressed = new MutableBoolean();

        addAction(Actions.forever(Actions.run(() -> {
            if(isPressed()) {
                if(!wasPressed.value) {
                    addAction(Actions.alpha(
                        PRESSED_OPACITY,
                        DURATION,
                        Interpolation.fade
                    ));
                }

                wasPressed.value = true;
            } else {
                if(wasPressed.value) {
                    addAction(Actions.alpha(1f, DURATION, Interpolation.fade));
                }

                wasPressed.value = false;
            }
        })));
    }
}
