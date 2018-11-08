package ktu.tanks.command;

import ktu.tanks.Direction;
import ktu.tanks.command.base.Command;
import ktu.tanks.entities.PlayerEntity;

public class ControlRight extends Command {
    private PlayerEntity player;

    public ControlRight(PlayerEntity p) { player = p; }

    public void move() {
        player.getEntity().setDirection(Direction.Right);
        player.getEntity().setMoving(true);
    }
}