package org.engine.presentation.scenes;

import java.util.ArrayList;
import java.util.Arrays;
import org.engine.core.elements.Element;
import org.engine.core.rulers.camera.CameraRuler;
import org.engine.core.scenes.Scene;
import org.engine.presentation.elements.Block;
import org.engine.presentation.elements.StaticBlock;

public class ExampleLevel extends Scene {
    public ExampleLevel() {
        name = "Example level";

        final StaticBlock floor = StaticBlock.build(0, 0, 1000, 50, "Floor");
        final Block block = Block.build(0, 600, 100, 100, "Movable block");

        CameraRuler.getInstance().setFocus(block);

        elements.addAll(new ArrayList<Element>(Arrays.asList(new Element[] {
                floor, block
        })));
    }

}
