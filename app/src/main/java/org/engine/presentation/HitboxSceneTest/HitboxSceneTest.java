package org.engine.presentation.HitboxSceneTest;

import org.engine.core.attributes.Vector2D;
import org.engine.core.rulers.camera.CameraRuler;
import org.engine.core.scenes.Scene;
import org.engine.presentation.HitboxSceneTest.elements.ColorChangerArea;
import org.engine.presentation.HitboxSceneTest.elements.RedSquare;

public class HitboxSceneTest extends Scene {
    private final RedSquare block = new RedSquare(0, 400);
    private final ColorChangerArea colorChanger = new ColorChangerArea(0, 200);

    public HitboxSceneTest() {
        super("Hitbox scene");
        CameraRuler.getInstance().setFocus(block.getPosition());
        this.addElement(block);
        this.addElement(colorChanger);
        this.block.slide(new Vector2D(0, -400), 10_000);
    }
}
