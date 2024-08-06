package org.engine.core.rules.time;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimeRule {
    private Timer currentTimer = new Timer();
    private TimeState state = TimeState.UNDEFINED;
    private int fpsCap = TimeRule.SIXTY_FPS;
    private final ArrayList<TimeListener> physicsListeners = new ArrayList<TimeListener>();

    public static final int SIXTY_FPS = 16;
    public static final int THIRTY_FPS = 33;
    public static final int NO_CAP = -1;

    private static TimeRule instance;

    public static TimeRule getInstance() {
        if (instance == null) {
            instance = new TimeRule();
        }
        return instance;
    }

    public void changeFpsCap(int fpsCap) {
        this.fpsCap = fpsCap;
    }

    public void run() {
        if (state == TimeState.RUNNING) {
            System.err.println("Physics already running");
            return;
        }

        state = TimeState.RUNNING;

        if (fpsCap == TimeRule.NO_CAP) {
            // create a thread with infinite loop.
            return;
        }

        currentTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyListeners(fpsCap);
            }
        }, 0, fpsCap);
    }

    public void pause() {
        if (state == TimeState.WAITING) {
            System.err.println("Physics already pausing");
            return;
        }

        if (fpsCap == TimeRule.NO_CAP) {
            // create a thread with infinite loop.
            return;
        }

        currentTimer.cancel();

        state = TimeState.WAITING;

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
