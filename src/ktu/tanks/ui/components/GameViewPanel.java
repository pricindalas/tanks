package ktu.tanks.ui.components;

import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.tiles.Tile;
import ktu.tanks.tiles.TileManager;
import ktu.tanks.ui.Viewport;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameViewPanel extends JComponent {

    private static final int SIZE = 512;

    private List<PlayerEntity> players;
    private List<Tile> tiles;

    private final Color bgColor = new Color(96, 96, 128);
    private final Color textColor = new Color(0, 0, 0);

    private int ticks = 0;

    private Viewport viewport;
    private TileManager tileManager;

    public GameViewPanel(List<PlayerEntity> players) {
        Dimension dimension = new Dimension();
        dimension.width = SIZE;
        dimension.height = SIZE;
        this.setPreferredSize(dimension);
        this.players = players;
        this.viewport = new Viewport(SIZE, SIZE);
        this.tileManager = new TileManager();
        this.tiles = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, SIZE, SIZE);

        for (Tile tile : tiles) {
            tile.render(g, viewport);
        }

        for (PlayerEntity playerEntity : players) {
            playerEntity.render(g, viewport);
        }

        g.setColor(textColor);
        g.drawString("X: " + viewport.getX() + " Y: " + viewport.getY() + " Frame: " + ticks++, 10, 10);
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles.clear();
        for (Tile tile : tiles) {
            tile.setTileManager(tileManager);
            this.tiles.add(tile);
        }
    }
}
