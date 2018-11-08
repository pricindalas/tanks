package ktu.tanks.command;

import ktu.tanks.Direction;
import ktu.tanks.command.base.Command;
import ktu.tanks.entities.PlayerEntity;

public class ControlLeft extends Command {
    private PlayerEntity player;

    public ControlLeft(PlayerEntity p) { player = p; }

    public void move() {
        player.getEntity().setDirection(Direction.Left);
        player.getEntity().setMoving(true);
    }
}