package com.wgsoft.actor;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.wgsoft.util.MutableBoolean;

public class OpacityCheckBox extends CheckBox {
    private static final float DURATION = 0.2f;

    public OpacityCheckBox(final CheckBox.CheckBoxStyle style) {
        super(null, style);
        initialize();
    }

    public OpacityCheckBox(final Skin skin) {
        super(null, skin);
        initialize();
    }

    public OpacityCheckBox(final Skin skin, final String styleName) {
        super(null, skin, styleName);
        initialize();
    }

    private void initialize() {
        final MutableBoolean wasChecked = new MutableBoolean();

        getColor().a = 0f;

        addAction(Actions.forever(Actions.run(() -> {
            if(isChecked()) {
                if(!wasChecked.value) {
                    addAction(Actions.alpha(1f, DURATION, Interpolation.fade));
                }

                wasChecked.value = true;
            } else {
                if(wasChecked.value) {
                    addAction(Actions.alpha(0f, DURATION, Interpolation.fade));
                }

                wasChecked.value = false;
            }
        })));
    }
}
