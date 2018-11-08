package ktu.tanks.builders.base;

import ktu.tanks.entities.base.Tank;

public abstract class TankBuilder {

    protected Tank tank;

    public abstract TankBuilder startNew();

    public TankBuilder setModel(String model) {
        tank.setModel(model);
        return this;
    }

    public TankBuilder setHealth(int health) {
        tank.setHealth(health);
        return this;
    }

    public TankBuilder setMovementSpeed(int movementSpeed) {
        tank.setMovementSpeed(movementSpeed);
        return this;
    }

    public Tank finish() {
        return tank;
    }
}
