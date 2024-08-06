package org.engine.core.levels;

import java.util.ArrayList;
import javax.swing.JPanel;
import org.engine.core.elements.Element;

public abstract class Level extends JPanel {
    public String name;
    public ArrayList<Element> elements;
}
