package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.PositionNode;
import org.engine.tools.Constants;

public class Block extends GameObject {
    public final PositionNode positionNode;

    public Block(int posX, int posY, @Nullable UUID key) {
        super(key);
        this.positionNode = new PositionNode(posX, posY);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Constants.CUSTOM_RED.darker());
        g.drawRect(positionNode.getPosX(), positionNode.getPosY(), 40, 40);
        g.setColor(Constants.CUSTOM_RED);
        g.fillRect(positionNode.getPosX(), positionNode.getPosY(), 40, 40);
    }
}
