package ktu.tanks.entities;

public class TankMediator implements Mediator {
    LightTank lightTank;
    HeavyTank heavyTank;

    @Override
    public void registerHeavy(HeavyTank h) {
        this.heavyTank = h;
    }

    @Override
    public void registerLight(LightTank l) {
        this.lightTank = l;
    }

    @Override
    public void attack() {

    }
}
