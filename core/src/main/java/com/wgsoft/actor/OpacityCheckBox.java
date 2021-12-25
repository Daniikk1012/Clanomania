package com.wgsoft.actor;

import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;

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
        addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                if(isChecked()) {
                    addAction(Actions.alpha(1f, DURATION, Interpolation.fade));
                } else {
                    addAction(Actions.alpha(0f, DURATION, Interpolation.fade));
                }
            }
        });
    }
}
