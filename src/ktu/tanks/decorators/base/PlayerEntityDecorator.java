package ktu.tanks.decorators.base;

import ktu.tanks.entities.PlayerEntity;

public abstract class PlayerEntityDecorator extends PlayerEntity {

    public PlayerEntityDecorator(PlayerEntity playerEntity) {
        super(playerEntity.getPlayerName(), playerEntity.getEntity());
    }

}
