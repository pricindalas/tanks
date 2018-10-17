package ktu.tanks.decorators;

import ktu.tanks.entities.Tank;

import java.awt.*;

public abstract class PlayerTankDecorator implements Renderable {
    private Tank tank;

    public PlayerTankDecorator(Tank tank) {
        this.tank = tank;
    }

    @Override
    public void render(Graphics g) {
        tank.render(g);
        g.drawString(tank.getPlayerName(), tank.getX(), tank.getY());
    }
}
