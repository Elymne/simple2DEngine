package org.engine.core.physics.time;

public interface TimeListener {
    public abstract void onNextFrame(int timeDelta);
}
