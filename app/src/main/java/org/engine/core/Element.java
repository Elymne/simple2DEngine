package org.engine.core;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nullable;

abstract public class Element {
    private final UUID key;
    protected ArrayList<Characteristic> nodes = new ArrayList<Characteristic>();

    protected Element(@Nullable UUID key) {
        if (key == null) {
            this.key = UUID.randomUUID();
            return;
        }
        this.key = key;
    }

    public UUID getKey() {
        return key;
    }

    public boolean removeNode(Class<Characteristic> nodeClass) {
        return nodes.removeIf(node -> node.getClass() == nodeClass);
    }

    public boolean addNode(Characteristic node) {
        if (findNode(node.getClass()) != null) {
            return false;
        }
        return nodes.add(node);
    }

    @Nullable
    public Characteristic findNode(Class<? extends Characteristic> nodeClass) {
        for (Characteristic node : nodes) {
            if (node.getClass() == nodeClass) {
                return node;
            }
        }
        return null;
    }

    abstract public void paint(Graphics g);
}
