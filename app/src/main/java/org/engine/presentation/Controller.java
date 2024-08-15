package org.engine.presentation;

import org.engine.core.rulers.camera.CameraRuler;
import org.engine.core.rulers.frame.FrameRuler;
import org.engine.core.rulers.scene.SceneRuler;
import org.engine.core.rulers.time.TimeListener;
import org.engine.core.rulers.time.TimeRuler;
import org.engine.presentation.scenes.MoveBlockScene;

public class Controller implements TimeListener {
    private final TimeRuler timeRuler = TimeRuler.getInstance();
    private final SceneRuler sceneRuler = SceneRuler.getInstance();
    private final FrameRuler frameRuler = FrameRuler.getInstance();
    private final CameraRuler cameraRuler = CameraRuler.getInstance();

    public void setupScreen() {
        this.frameRuler.init(sceneRuler, "Engine Test", 1080, 720);
        this.frameRuler.setDisplayMode(FrameRuler.WINDOWED_MODE);
        this.frameRuler.setVisible(true);
        this.cameraRuler.init(frameRuler);
        this.timeRuler.addNewListener(this);
    }

    public void start() {
        this.sceneRuler.setCurrentScene(new MoveBlockScene());
        this.timeRuler.run(TimeRuler.SIXTY_FPS);
    }

    @Override
    public void onNextFrame(int time) {
        this.sceneRuler.drawFrame();
    }
}
