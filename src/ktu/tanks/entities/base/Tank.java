package ktu.tanks.entities.base;

import ktu.tanks.entities.Mediator;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public abstract class Tank extends Entity {
    protected String model;
    private Mediator mediator;

    @Override
    public void render(Graphics g, Viewport viewport) {
        g.drawImage(getImage(), viewport.transformX(x), viewport.transformY(y), null);
    }

    public void sendAttack(){
        System.out.println("Attack!!");
    }

    public void receiveAttack(){
        System.out.println("Arghhh?!");
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
