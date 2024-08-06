package org.engine.core.characteristics;

import org.engine.core.rules.camera.CameraRule;
import org.engine.core.rules.metric.MetricRule;

abstract public class Shape extends Characteristic {
    public Position positionNode;

    protected MetricRule metric = MetricRule.getInstance();
    protected CameraRule camera = CameraRule.getInstance();
}
