package ktu.tanks.decorators;

import ktu.tanks.decorators.base.PlayerEntityDecorator;
import ktu.tanks.entities.PlayerEntity;

import java.awt.*;

public class NamedPlayerEntity extends PlayerEntityDecorator {

    public NamedPlayerEntity(PlayerEntity playerEntity) {
        super(playerEntity);
    }

    @Override
    public void render(Graphics g) {
        getPlayerEntity().render(g);
        g.setColor(Color.BLACK);
        g.drawString(getPlayerName(), getPlayerEntity().getX(), getPlayerEntity().getY());
    }
}
