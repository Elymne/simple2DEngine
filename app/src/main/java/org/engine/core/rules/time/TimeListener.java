package org.engine.core.rules.time;

public interface TimeListener {
    public abstract void onNextFrame(int timeDelta);
}
