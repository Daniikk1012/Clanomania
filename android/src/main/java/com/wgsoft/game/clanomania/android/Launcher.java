package com.wgsoft.game.clanomania.android;

import android.os.Bundle;
import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.wgsoft.game.clanomania.Clanomania;

public final class Launcher extends AndroidApplication {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final AndroidApplicationConfiguration configuration =
            new AndroidApplicationConfiguration();
        configuration.useAccelerometer = false;
        configuration.useCompass = false;

        initialize(new Clanomania(), configuration);
    }
}
