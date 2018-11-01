package ktu.tanks.entities.base;

import java.awt.*;

public abstract class Tank extends Entity {
    protected String model;

    @Override
    public void render(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
