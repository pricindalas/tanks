package ktu.tanks.command;

import ktu.tanks.entities.PlayerEntity;

public class ControlInvoker {
    public void moveLeft(PlayerEntity player) {
        new ControlLeft(player).move();
    }
    public void moveRight(PlayerEntity player) {
        new ControlRight(player).move();
    }
    public void moveUp(PlayerEntity player) {
        new ControlUp(player).move();
    }
    public void moveDown(PlayerEntity player) {
        new ControlDown(player).move();
    }
    public void stop(PlayerEntity player) { new ControlStop(player).move();}
}
