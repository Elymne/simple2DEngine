package org.engine.presentation;

import org.engine.core.levels.Level;
import org.engine.core.rules.time.TimeListener;
import org.engine.core.rules.time.TimeRule;
import org.engine.core.rules.viewport.ViewportRule;
import org.engine.presentation.levels.ExampleLevel;

public class Screen implements TimeListener {
    private Level currentLevel = null;

    public void setupScreen() {
        final ViewportRule viewportRule = ViewportRule.getInstance();
        viewportRule.setTitle("Game Engine");
        viewportRule.setViewport(1080, 720);
        viewportRule.setScreenMode(ViewportRule.WINDOWED_MODE);
        viewportRule.start();

        final TimeRule timeRule = TimeRule.getInstance();
        timeRule.setFrameRate(TimeRule.SIXTY_FPS);
        timeRule.addNewListener(this);
    }

    public void start() {
        try {
            final ViewportRule viewport = ViewportRule.getInstance();
            currentLevel = new ExampleLevel();
            viewport.renderLevel(currentLevel);
            TimeRule.getInstance().run();
        } catch (Exception e) {
            currentLevel = null;
            TimeRule.getInstance().pause();
            e.printStackTrace();
        }
    }

    public void clearLevel() {
        final ViewportRule viewport = ViewportRule.getInstance();
        viewport.clearLevel(currentLevel);
        currentLevel = null;
        TimeRule.getInstance().pause();
    }

    @Override
    public void onNextFrame(int time) {
        if (currentLevel != null) {
            currentLevel.repaint();
            currentLevel.revalidate();
        }
    }

}
