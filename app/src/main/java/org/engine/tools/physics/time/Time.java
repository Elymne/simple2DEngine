package org.engine.tools.physics.time;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Time {
    private Timer currentTimer = new Timer();
    private TimeState state = TimeState.UNDEFINED;
    private final ArrayList<TimeListener> physicsListeners = new ArrayList<TimeListener>();

    private static Time instance;

    public static Time getInstance() {
        if (instance == null) {
            instance = new Time();
        }
        return instance;
    }

    public void run(int fpsTarget) {
        if (state == TimeState.RUNNING) {
            System.err.println("Physics already running");
            return;
        }
        state = TimeState.RUNNING;
        currentTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyListeners(fpsTarget);
            }
        }, 0, fpsTarget);
    }

    public void pause() {
        if (state == TimeState.WAITING) {
            System.err.println("Physics already pausing");
            return;
        }
        state = TimeState.WAITING;
        currentTimer.cancel();
    }

    public void addNewListener(TimeListener physicsListener) {
        physicsListeners.add(physicsListener);
    }

    public void removeListener(TimeListener physicsListener) {
        physicsListeners.remove(physicsListener);
    }

    private void notifyListeners(int fpsTarget) {
        for (TimeListener physicsListener : physicsListeners) {
            physicsListener.onNextFrame(fpsTarget);
        }
    }

}
