package com.wgsoft.game.clanomania.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ButtonGroup;
import com.badlogic.gdx.scenes.scene2d.ui.HorizontalGroup;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.wgsoft.actor.OpacityCheckBox;
import com.wgsoft.actor.OpacityTextButton;
import com.wgsoft.game.clanomania.Clanomania;
import com.wgsoft.game.clanomania.Constants;
import com.wgsoft.game.clanomania.actor.Background;
import com.wgsoft.game.clanomania.actor.game.Clan;

public final class GameScreen extends ScreenAdapter {
    private final Stage stage;

    public GameScreen(final Clanomania game) {
        stage = new Stage(new ScreenViewport(), game.getSpriteBatch());

        stage.addActor(new Background(game.getSkin()));

        final Table root = new Table();
        root.setFillParent(true);

        root.add().expandY();
        root.row();

        final HorizontalGroup clans = new HorizontalGroup();
        clans.space(32f);

        final ButtonGroup<OpacityCheckBox> arrows = new ButtonGroup<>();

        for(final Clan.ClanColor color: Clan.ClanColor.values()) {
            clans.addActor(
                new Clan(color.toString(), arrows, game.getSkin(), color)
            );
        }

        arrows.getButtons().get(0).setChecked(true);

        final ScrollPane scrollPane = new ScrollPane(clans);
        root.add(scrollPane).growX();

        stage.setScrollFocus(scrollPane);

        root.row();
        root.add().expandY();
        root.row();

        final HorizontalGroup actions = new HorizontalGroup();
        actions.space(32f);
        actions.align(Align.center);

        actions.addActor(
            new OpacityTextButton("Pass", game.getSkin(), "action")
        );

        actions.addActor(
            new OpacityTextButton("Switch", game.getSkin(), "action")
        );

        root.add(actions);

        stage.addActor(root);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(final float delta) {
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(final int width, final int height) {
        ((ScreenViewport)stage.getViewport()).setUnitsPerPixel(
            width * Constants.SCREEN_HEIGHT > Constants.SCREEN_WIDTH * height
                ? Constants.SCREEN_HEIGHT / height
                : Constants.SCREEN_WIDTH / width
        );
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void hide() {
        Gdx.input.setInputProcessor(null);
    }

    @Override
    public void dispose() {
        stage.dispose();
    }
}
