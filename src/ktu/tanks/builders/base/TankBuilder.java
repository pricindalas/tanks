package ktu.tanks.builders.base;

import ktu.tanks.entities.base.Tank;

public abstract class TankBuilder {

    protected Tank tank;

    public abstract TankBuilder startNew();

    public abstract TankBuilder setModel(String model);

    public abstract TankBuilder setHealth(int health);

    public abstract TankBuilder setMovementSpeed(int movementSpeed);

    public Tank finish() {
        return tank;
    }
}
