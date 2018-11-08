package ktu.tanks.command;

import ktu.tanks.Direction;
import ktu.tanks.command.base.Command;
import ktu.tanks.entities.PlayerEntity;

public class ControlUp extends Command {
    private PlayerEntity player;

    public ControlUp(PlayerEntity p) { player = p; }

    public void move() {
        player.getEntity().setDirection(Direction.Up);
        player.getEntity().setMoving(true);
    }
}