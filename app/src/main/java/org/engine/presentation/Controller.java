package org.engine.presentation;

import org.engine.core.rules.scene.SceneRuler;
import org.engine.core.rules.time.TimeListener;
import org.engine.core.rules.time.TimeRule;
import org.engine.core.rules.viewport.ViewportRuler;
import org.engine.presentation.levels.ExampleLevel;

public class Controller implements TimeListener {
    private final ViewportRuler viewportRule = ViewportRuler.getInstance();
    private final TimeRule timeRule = TimeRule.getInstance();
    private final SceneRuler sceneRuler = SceneRuler.getInstance();

    public void setupScreen() {
        viewportRule.setTitle("Game Engine");
        viewportRule.setViewport(1080, 720);
        viewportRule.setScreenMode(ViewportRuler.WINDOWED_MODE);
        viewportRule.start();

        timeRule.setFrameRate(TimeRule.SIXTY_FPS);
        timeRule.addNewListener(this);
    }

    public void start() {
        sceneRuler.setCurrentScene(new ExampleLevel());
        timeRule.run();

    }

    @Override
    public void onNextFrame(int time) {
        sceneRuler.drawFrame();
    }

}
