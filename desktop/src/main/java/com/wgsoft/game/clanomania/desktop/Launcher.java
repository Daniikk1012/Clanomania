package com.wgsoft.game.clanomania.desktop;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import com.wgsoft.game.clanomania.Clanomania;

public final class Launcher {
    public static void main(final String[] args) {
        final Lwjgl3ApplicationConfiguration configuration =
            new Lwjgl3ApplicationConfiguration();
        configuration.setTitle("Clanomania");
        configuration.setWindowedMode(800, 480);

        new Lwjgl3Application(new Clanomania(), configuration);
    }
}
