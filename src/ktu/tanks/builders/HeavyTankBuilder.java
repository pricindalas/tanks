package ktu.tanks.builders;

import ktu.tanks.builders.base.TankBuilder;
import ktu.tanks.entities.HeavyTank;

public class HeavyTankBuilder extends TankBuilder {

    @Override
    public TankBuilder startNew() {
        tank = new HeavyTank();
        return this;
    }

}
