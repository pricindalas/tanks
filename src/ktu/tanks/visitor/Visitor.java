package ktu.tanks.visitor;

import ktu.tanks.health.Health;
import ktu.tanks.models.Player;

public interface Visitor {
    int visit(Player player);
    int visit(Health health);
}
