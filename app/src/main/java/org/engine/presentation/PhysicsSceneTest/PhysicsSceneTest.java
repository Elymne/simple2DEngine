package org.engine.presentation.PhysicsSceneTest;

import org.engine.core.attributes.Vector2D;
import org.engine.core.rulers.camera.CameraRuler;
import org.engine.core.scenes.Scene;
import org.engine.presentation.PhysicsSceneTest.elements.FallingBlock;
import org.engine.presentation.PhysicsSceneTest.elements.Floor;

public class PhysicsSceneTest extends Scene {
    private Floor floor = new Floor(0, 0);
    private FallingBlock fallingBlock = new FallingBlock(0, 1200);
    private FallingBlock fallingBlock2 = new FallingBlock(10, 400);
    private FallingBlock fallingBlock3 = new FallingBlock(200, 600);
    private FallingBlock fallingBlock4 = new FallingBlock(20, 1400);
    private FallingBlock fallingBlock5 = new FallingBlock(100, 2000);
    private FallingBlock fallingBlock6 = new FallingBlock(-200, 2200);
    private FallingBlock fallingBlock7 = new FallingBlock(-400, 800);
    private FallingBlock fallingBlock8 = new FallingBlock(400, 200);

    public PhysicsSceneTest() {
        super("Physics scene");
        CameraRuler.getInstance().setFocus(new Vector2D(0, 200));
        this.addElement(floor);
        this.addElement(fallingBlock);
        this.addElement(fallingBlock2);
        this.addElement(fallingBlock3);
        this.addElement(fallingBlock4);
        this.addElement(fallingBlock5);
        this.addElement(fallingBlock6);
        this.addElement(fallingBlock7);
        this.addElement(fallingBlock8);
    }
}
