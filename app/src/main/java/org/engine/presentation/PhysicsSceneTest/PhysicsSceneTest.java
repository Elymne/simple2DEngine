package org.engine.presentation.PhysicsSceneTest;

import org.engine.core.scenes.Scene;
import org.engine.presentation.PhysicsSceneTest.elements.FallingBlock;
import org.engine.presentation.PhysicsSceneTest.elements.Floor;

public class PhysicsSceneTest extends Scene {
    private Floor floor = new Floor(0, 0);
    private FallingBlock fallingBlock = new FallingBlock(0, 200);

    public PhysicsSceneTest() {
        super("Physics scene");
        cameraRuler.setFocus(fallingBlock);
        this.addElement(floor);
        this.addElement(fallingBlock);
    }

}
