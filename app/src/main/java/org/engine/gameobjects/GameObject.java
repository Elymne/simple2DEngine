package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.Node;

abstract public class GameObject {
    private final UUID key;
    protected ArrayList<Node> nodes = new ArrayList<Node>();

    protected GameObject(@Nullable UUID key) {
        if (key == null) {
            this.key = UUID.randomUUID();
            return;
        }
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    public boolean removeNode(Class<Node> nodeClass) {
        return nodes.removeIf(node -> node.getClass() == nodeClass);
    }

    public boolean addNode(Node node) {
        if (findNode(node.getClass()) != null) {
            return false;
        }
        return nodes.add(node);
    }

    @Nullable
    public Node findNode(Class<? extends Node> nodeClass) {
        for (Node node : nodes) {
            if (node.getClass() == nodeClass) {
                return node;
            }
        }
        return null;
    }

    abstract public void paint(Graphics g);
}
