package com.wgsoft.actor;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.wgsoft.util.MutableBoolean;

public final class OpacityTextButton extends TextButton {
    private static final float PRESSED_OPACITY = 0.5f;
    private static final float DURATION = 0.125f;

    public OpacityTextButton(final String text, final Skin skin) {
        super(text, skin);
        initialize();
    }

    public OpacityTextButton(
        final String text,
        final Skin skin,
        final String styleName
    ) {
        super(text, skin, styleName);
        initialize();
    }

    public OpacityTextButton(final String text, final TextButtonStyle style) {
        super(text, style);
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
