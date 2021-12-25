package com.wgsoft.game.clanomania.actor.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Stack;
import com.badlogic.gdx.scenes.scene2d.ui.VerticalGroup;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.utils.Align;
import com.wgsoft.actor.OpacityButton;
import com.wgsoft.actor.OpacityCheckBox;

public final class Clan extends VerticalGroup {
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

    public Clan(
        final String name,
        final ButtonGroup<OpacityCheckBox> group,
        final Skin skin,
        final ClanColor clanColor
    ) {
        space(32f);

        final Color color = skin.getColor("clan-" + clanColor.ordinal());

        final OpacityCheckBox arrow = new OpacityCheckBox(skin, "arrow");
        arrow.setDisabled(true);
        arrow.setColor(color);
        group.add(arrow);
        addActor(arrow);

        final OpacityButton button = new OpacityButton(skin, "clan");

        button.addListener(new ChangeListener() {
            @Override
            public void changed(final ChangeEvent event, final Actor actor) {
                arrow.setChecked(true);
            }
        });

        button.setColor(color);

        final Label label = new Label(name, skin, "montserrat-regular-medium");
        label.setTouchable(Touchable.disabled);
        label.setAlignment(Align.center);

        label.addAction(Actions.forever(Actions.run(() -> {
            label.getColor().a = button.getColor().a;
        })));

        addActor(new Stack(button, label));
    }
}
