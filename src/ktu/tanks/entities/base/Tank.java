package ktu.tanks.entities.base;

import ktu.tanks.ui.Viewport;

import java.awt.*;

public abstract class Tank extends Entity {
    protected String model;

    @Override
    public void render(Graphics g, Viewport viewport) {
        g.drawImage(getImage(), viewport.transformX(x), viewport.transformY(y), null);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
