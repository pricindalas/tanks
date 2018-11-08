package ktu.tanks.builders;

import ktu.tanks.builders.base.TankBuilder;
import ktu.tanks.entities.LightTank;

public class LightTankBuilder extends TankBuilder {

    @Override
    public TankBuilder startNew() {
        tank = new LightTank();
        return this;
    }

}
