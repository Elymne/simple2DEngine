package org.engine.gameobjects;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.nodes.Node;

abstract public class GameObject {
    private final UUID key;
    protected ArrayList<Node> nodes;

    public GameObject(@Nullable UUID key) {
        if (key == null) {
            this.key = UUID.randomUUID();
            return;
        }
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    protected boolean removeNode(Class<Node> nodeClass) {
        return nodes.removeIf(node -> node.getClass() == nodeClass);
    }

    protected boolean addNode(Node node) {
        if (findNode(node.getClass()) != null) {
            return false;
        }
        return nodes.add(node);

    }

    @Nullable
    protected Node findNode(Class<? extends Node> nodeClass) {
        for (Node node : nodes) {
            if (node.getClass() == nodeClass) {
                return node;
            }
        }
        return null;
    }

    abstract public void paint(Graphics g);
}
