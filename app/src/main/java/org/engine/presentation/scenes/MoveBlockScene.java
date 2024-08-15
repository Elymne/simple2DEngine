package org.engine.presentation.scenes;

import org.engine.core.rulers.camera.CameraRuler;
import org.engine.core.scenes.Scene;
import org.engine.presentation.elements.FloorBlock;
import org.engine.presentation.elements.MovableBlock;

public class MoveBlockScene extends Scene {
    private final CameraRuler cameraRuler = CameraRuler.getInstance();
    private final FloorBlock floor = new FloorBlock(0, 0);
    private final MovableBlock block = new MovableBlock(0, 100);

    public MoveBlockScene() {
        super("MoveBlockScene");
        cameraRuler.setFocus(block);
        this.addElement(this.floor);
        this.addElement(this.block);
    }
}
