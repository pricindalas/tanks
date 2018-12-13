package ktu.tanks.entities;

import ktu.tanks.entities.base.Tank;

public class TankMediator implements Mediator {

//    Tank
    Tank lightTank;
    Tank heavyTank;

    @Override
    public void registerHeavy(Tank h) {
        this.heavyTank = h;
    }

    @Override
    public void registerLight(Tank l) {
        this.lightTank = l;
    }

    @Override
    public void lightAttack() {
        lightTank.sendAttack();
        heavyTank.receiveAttack();
    }

    @Override
    public void heavyAttack() {
        lightTank.receiveAttack();
        heavyTank.sendAttack();
    }
}
