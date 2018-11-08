package ktu.tanks.builders;

import ktu.tanks.builders.base.TankBuilder;
import ktu.tanks.entities.HeavyTank;

public class HeavyTankBuilder extends TankBuilder {
    @Override
    public TankBuilder startNew() {
        tank = new HeavyTank();
        return this;
    }

    @Override
    public TankBuilder setModel(String model) {
        tank.setModel(model);
        return this;
    }

    @Override
    public TankBuilder setHealth(int health) {
        tank.setHealth(health);
        return this;
    }

    @Override
    public TankBuilder setMovementSpeed(int movementSpeed) {
        tank.setMovementSpeed(movementSpeed);
        return this;
    }
}
