package org.engine.gameobjects;

import java.util.UUID;
import javax.annotation.Nullable;
import java.awt.*;

abstract public class GameObject {
    private final UUID key;

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

    abstract public void paint(Graphics g);
}
