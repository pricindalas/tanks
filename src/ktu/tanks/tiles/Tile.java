package ktu.tanks.tiles;

import ktu.tanks.decorators.Renderable;

import java.awt.*;

public class Tile implements Renderable {
    private int tileId;
    private int indX;
    private int indY;

    private TileManager tileManager;

    public Tile(TileManager tileManager, int tileId, int indX, int indY) {
        this.tileManager = tileManager;
        this.tileId = tileId;
        this.indX = indX;
        this.indY = indY;
    }

    public int getX() {
        return indX * 64;
    }

    public int getY() {
        return indY * 64;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(tileManager.getTileImage(tileId), getX(), getY(), null);
    }
}
