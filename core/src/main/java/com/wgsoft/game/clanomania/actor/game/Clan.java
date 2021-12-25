package com.wgsoft.game.clanomania.actor.game;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.utils.Align;
import com.wgsoft.actor.OpacityButton;

public final class Clan extends Stack {
    public enum ClanColor {
        RED,
        ORANGE,
        YELLOW,
        GREEN,
        CYAN,
        BLUE,
        PURPLE,
        VIOLET;

        @Override
        public String toString() {
            return name().charAt(0) + name().substring(1).toLowerCase();
        }
    }

    public Clan(final String name, final Skin skin, final ClanColor color) {
        final OpacityButton button = new OpacityButton(skin, "clan");
        button.setColor(skin.getColor("clan-" + color.ordinal()));
        add(button);

        final Label label = new Label(name, skin, "montserrat-regular-medium");
        label.setTouchable(Touchable.disabled);
        label.setAlignment(Align.center);

        label.addAction(Actions.forever(Actions.run(() -> {
            label.getColor().a = button.getColor().a;
        })));

        add(label);
    }
}
