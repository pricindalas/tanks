package ktu.tanks.entities;

import ktu.tanks.entities.base.Tank;

public interface Mediator {
    void registerLight(Tank l);
    void registerHeavy(Tank h);
    void heavyAttack();
    void lightAttack();
}
