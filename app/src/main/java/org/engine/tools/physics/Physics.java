package org.engine.tools.physics;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class Physics {
    private Timer currentTimer = new Timer();
    private PhysicsState state = PhysicsState.UNDEFINED;
    private final ArrayList<PhysicsListener> physicsListeners = new ArrayList<PhysicsListener>();

    private static Physics instance;

    public static Physics getInstance() {
        if (instance == null) {
            instance = new Physics();
        }
        return instance;
    }

    public void run(int fpsTarget) {
        if (state == PhysicsState.RUNNING) {
            System.err.println("Physics already running");
            return;
        }
        state = PhysicsState.RUNNING;
        currentTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                for (PhysicsListener physicsListener : physicsListeners) {
                    physicsListener.onNextFrame(fpsTarget);
                }
            }
        }, 0, fpsTarget);
    }

    public void pause() {
        if (state == PhysicsState.WAITING) {
            System.err.println("Physics already pausing");
            return;
        }
        state = PhysicsState.WAITING;
        currentTimer.cancel();
    }

    public void addNewListener(PhysicsListener physicsListener) {
        physicsListeners.add(physicsListener);
    }

    public void removeNewListener(PhysicsListener physicsListener) {
        physicsListeners.remove(physicsListener);
    }

}
