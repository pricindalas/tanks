package ktu.tanks.builders;

import ktu.tanks.entities.base.Tank;

public abstract class TankBuilder {

    private Tank tank;

    abstract TankBuilder startNew();

    abstract TankBuilder setModel(String model);

    abstract TankBuilder setHealth(int health);

    abstract TankBuilder setMovementSpeed(int movementSpeed);

    public Tank finish() {
        return tank;
    }
}
