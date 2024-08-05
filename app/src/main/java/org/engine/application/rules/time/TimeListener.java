package org.engine.application.rules.time;

public interface TimeListener {
    public abstract void onNextFrame(int timeDelta);
}
