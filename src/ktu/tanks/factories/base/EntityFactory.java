package ktu.tanks.factories.base;

import ktu.tanks.entities.base.Entity;

public abstract class EntityFactory {
    public abstract Entity produce(String type);
}
