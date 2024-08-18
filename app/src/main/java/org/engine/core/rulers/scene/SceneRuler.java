package org.engine.core.rulers.scene;

import java.awt.Graphics;
import javax.annotation.Nullable;
import javax.swing.JPanel;
import org.engine.core.elements.Element;
import org.engine.core.elements.shapes.Shape;
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
        return currentScene;
    }

    public void drawFrame() {
        repaint();
        revalidate();
    }

    @SuppressWarnings("null")
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (currentScene == null) {
            System.err.println("No scene is currently running. Cannot draw frames.");
            return;
        }
        for (Element element : currentScene.getElements()) {
            if (element instanceof Shape) {
                ((Shape) element).drawFrame(g);
            }
        }
    }
}
