package ktu.tanks.visitor;

import ktu.tanks.health.Health;
import ktu.tanks.models.Player;
import ktu.tanks.ui.Viewport;

public class DistanceCalcInMeters implements Visitor {
    private Viewport viewport;

    public DistanceCalcInMeters(Viewport viewport) {
        this.viewport = viewport;
    }

    @Override
    public int visit(Player player) {
        return Double.valueOf(Math.sqrt(Math.pow(viewport.getX() - player.getPosX(), 2) + Math.pow(viewport.getY() - player.getPosY(), 2))).intValue() / 16;
    }

    @Override
    public int visit(Health health) {
        return Double.valueOf(Math.sqrt(Math.pow(viewport.getX() - health.getIndX() * 64, 2) + Math.pow(viewport.getY() - health.getIndY() * 64, 2))).intValue() / 16;
    }
}
