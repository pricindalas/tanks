package ktu.tanks.command;

import ktu.tanks.command.base.Command;
import ktu.tanks.entities.PlayerEntity;

public class ControlStop extends Command {
    private PlayerEntity player;

    public ControlStop(PlayerEntity p){ player = p;}

    public void move(){
        player.getEntity().setMoving(false);
    }
}
