package ktu.tanks.decorators;

import ktu.tanks.decorators.base.PlayerEntityDecorator;
import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public class NamedPlayerEntity extends PlayerEntityDecorator {

    public NamedPlayerEntity(PlayerEntity playerEntity) {
        super(playerEntity);
    }

    @Override
    public void render(Graphics g, Viewport viewport) {
        getPlayerEntity().render(g, viewport);
        g.setColor(Color.BLACK);
        g.drawString(getPlayerName(), viewport.transformX(getPlayerEntity().getX()), viewport.transformY(getPlayerEntity().getY()));
    }
}
