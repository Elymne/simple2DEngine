package org.engine.rework.rulers.time;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class TimeRuler {
    private final Timer currentTimer = new Timer();
    private int state = TimeRuler.UNDEFINED_STATE;
    private int refreshCap = TimeRuler.SIXTY_FPS;

    private final ArrayList<TimeListener> listeners = new ArrayList<TimeListener>();

    public static final int ONE_TWENTY_FPS = 8;
    public static final int SIXTY_FPS = 16;
    public static final int THIRTY_FPS = 33;

    public static final int UNDEFINED_STATE = 0;
    public static final int RUNNING_STATE = 1;
    public static final int WAITING_STATE = 2;

    private static TimeRuler instance;

    public static TimeRuler getInstance() {
        if (instance == null) {
            instance = new TimeRuler();
        }
        return instance;
    }

    public void run() {
        if (this.state == TimeRuler.RUNNING_STATE) {
            System.err.println("Time ruler is already running.");
            return;
        }
        state = TimeRuler.RUNNING_STATE;
        currentTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyListeners(refreshCap);
            }
        }, 0, refreshCap);
    }

    public void pause() {
        if (state == TimeRuler.WAITING_STATE) {
            System.err.println("Physics already pausing");
            return;
        }
        currentTimer.cancel();
        state = TimeRuler.WAITING_STATE;
    }

    public void updateFrameRate(int refreshCap) {
        this.refreshCap = refreshCap;

        currentTimer.cancel();
        currentTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                notifyListeners(refreshCap);
            }
        }, 0, refreshCap);
    }

    public void addNewListener(TimeListener physicsListener) {
        listeners.add(physicsListener);
    }

    public void removeListener(TimeListener physicsListener) {
        listeners.remove(physicsListener);
    }

    private void notifyListeners(int fpsTarget) {
        for (TimeListener listener : listeners) {
            listener.onNextFrame(fpsTarget);
        }
    }
}
