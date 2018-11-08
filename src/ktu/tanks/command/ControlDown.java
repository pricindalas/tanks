package ktu.tanks.command;

import ktu.tanks.Direction;
import ktu.tanks.command.base.Command;
import ktu.tanks.entities.PlayerEntity;

public class ControlDown extends Command {
    private PlayerEntity player;

    public ControlDown(PlayerEntity p) { player = p; }

    public void move() {
        player.getEntity().setDirection(Direction.Down);
        player.getEntity().setMoving(true);
    }
}
