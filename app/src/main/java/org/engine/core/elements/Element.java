package org.engine.core.elements;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.UUID;
import javax.annotation.Nullable;
import org.engine.core.characteristics.Characteristic;

abstract public class Element {
    private final String key;
    protected ArrayList<Characteristic> characteristic = new ArrayList<Characteristic>();

    protected Element(@Nullable String key) {
        if (key == null) {
            this.key = UUID.randomUUID().toString();
            return;
        }
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public boolean removeCharacteristic(Class<Characteristic> cClass) {
        return characteristic.removeIf(node -> node.getClass() == cClass);
    }

    public boolean addCharacteristic(Characteristic node) {
        if (findCharacteristic(node.getClass()) != null) {
            return false;
        }
        return characteristic.add(node);
    }

    @Nullable
    public Characteristic findCharacteristic(Class<? extends Characteristic> cClass) {
        for (Characteristic characteristic : characteristic) {
            if (characteristic.getClass() == cClass) {
                return characteristic;
            }
        }
        return null;
    }

    abstract public void paint(Graphics g);
}
