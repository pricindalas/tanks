package ktu.tanks.tiles;

import ktu.tanks.converters.PositionConverter;
import ktu.tanks.ui.Renderable;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public class Tile implements Renderable {
    private int tileId;
    private int indX;
    private int indY;

    private TileManager tileManager;

    public Tile() {}

    public int getTileId() {
        return tileId;
    }

    public void setTileId(int tileId) {
        this.tileId = tileId;
    }

    public int getIndX() {
        return indX;
    }

    public void setIndX(int indX) {
        this.indX = indX;
    }

    public int getIndY() {
        return indY;
    }

    public void setIndY(int indY) {
        this.indY = indY;
    }

    public TileManager getTileManager() {
        return tileManager;
    }

    public void setTileManager(TileManager tileManager) {
        this.tileManager = tileManager;
    }

    @Override
    public void render(Graphics g, Viewport viewport) {
        g.drawImage(tileManager.getTileImage(tileId), viewport.transformX(PositionConverter.IndToPos(indX)), viewport.transformY(PositionConverter.IndToPos(indY)), null);
    }
}
