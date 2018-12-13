package ktu.tanks.entities;

public interface Mediator {
    void registerLight(LightTank l);
    void registerHeavy(HeavyTank h);
    void attack();
}
