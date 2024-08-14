package org.engine.rework.rulers.scene;

import java.awt.Graphics;
import javax.annotation.Nullable;
import javax.swing.JPanel;
import org.engine.core.elements.Element;
import org.engine.core.scenes.Scene;

public class SceneRuler extends JPanel {
    private @Nullable Scene currentScene;

    private static SceneRuler instance;

    public static SceneRuler getInstance() {
        if (instance == null) {
            instance = new SceneRuler();
        }
        return instance;
    }

    public void setCurrentScene(Scene scene) {
        this.currentScene = scene;
    }

    public Scene getCurrentScene() {
        return this.currentScene;
    }

    public void clearScene() {
        this.currentScene = null;
    }

    public void drawFrame() {
        this.repaint();
        this.revalidate();
    }

    @SuppressWarnings("null")
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentScene == null) {
            System.err.println("No scene is currently running. Cannot draw frames.");
            return;
        }
        for (Element element : this.currentScene.getElements()) {
            element.paint(g);
        }
    }
}