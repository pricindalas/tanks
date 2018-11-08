package ktu.tanks.command.base;

public abstract class Command {
    public abstract void move();
    public void undo() { }
}
