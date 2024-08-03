package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;

public class StaticBlock extends GameObject {
    public StaticBlock(UUID key) {
        super(key);
    }

    @Override
    public void paint(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'paint'");
    }

}
