package ktu.tanks.decorators.base;

import ktu.tanks.decorators.Renderable;
import ktu.tanks.entities.PlayerEntity;

public abstract class PlayerEntityDecorator extends PlayerEntity implements Renderable {

    public PlayerEntityDecorator(PlayerEntity playerEntity) {
        super(playerEntity.getPlayerName(), playerEntity.getPlayerEntity());
    }

}
