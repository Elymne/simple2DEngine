package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.PositionNode;

public class Block extends GameObject {
    public final PositionNode positionNode;

    public Block(int posX, int posY, @Nullable UUID key) {
        super(key);
        this.positionNode = new PositionNode(posX, posY);
    }

    @Override
    public void paint(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'paint'");
    }
}
