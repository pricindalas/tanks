package ktu.tanks.factories;

import ktu.tanks.builders.HeavyTankBuilder;
import ktu.tanks.builders.LightTankBuilder;
import ktu.tanks.entities.base.Entity;
import ktu.tanks.entities.base.Tank;
import ktu.tanks.factories.base.EntityFactory;

public class TankFactory extends EntityFactory {

    private static int ltCount = 1;
    private static int htCount = 1;

    private LightTankBuilder lightTankBuilder;
    private HeavyTankBuilder heavyTankBuilder;

    public TankFactory() {
        lightTankBuilder = new LightTankBuilder();
        heavyTankBuilder = new HeavyTankBuilder();
    }

    @Override
    public Entity produce(String type) {
        switch (type) {
            case "lightTank":
                return produceLightTank();
            case "heavyTank":
                return produceHeavyTank();
            default:
                throw new RuntimeException("Cannot produce " + type);
        }
    }

    private Tank produceLightTank() {
        return lightTankBuilder
                .startNew()
                .setModel("Light Tank: " + ltCount++)
                .setHealth(150)
                .setMovementSpeed(8)
                .finish();
    }

    private Tank produceHeavyTank() {
        return heavyTankBuilder
                .startNew()
                .setModel("Heavy Tank: " + htCount++)
                .setHealth(300)
                .setMovementSpeed(3)
                .finish();
    }
}
