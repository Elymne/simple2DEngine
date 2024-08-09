package org.engine.presentation;

import org.engine.core.rulers.scene.SceneRuler;
import org.engine.core.rulers.time.TimeListener;
import org.engine.core.rulers.time.TimeRuler;
import org.engine.core.rulers.viewport.ViewportRuler;
import org.engine.presentation.scenes.ExampleLevel;

public class Controller implements TimeListener {
    private final ViewportRuler viewportRuler = ViewportRuler.getInstance();
    private final TimeRuler timeRuler = TimeRuler.getInstance();
    private final SceneRuler sceneRuler = SceneRuler.getInstance();

    public void setupScreen() {
        viewportRuler.initialiseViewPort();
        viewportRuler.setTitle("Game Engine");
        viewportRuler.setViewport(1080, 720);
        viewportRuler.setScreenMode(ViewportRuler.BORDERLESS_FULLSCREEN_MODE);
        viewportRuler.start();

        timeRuler.setFrameRate(TimeRuler.SIXTY_FPS);
        timeRuler.addNewListener(this);
    }

    public void start() {
        sceneRuler.setCurrentScene(new ExampleLevel());
        timeRuler.run();

    }

    @Override
    public void onNextFrame(int time) {
        sceneRuler.drawFrame();
    }

}
