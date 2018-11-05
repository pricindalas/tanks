package ktu.tanks.ui.components;

import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.tiles.Tile;
import ktu.tanks.tiles.TileManager;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class GameViewPanel extends JComponent {

    private static final int SIZE = 512;

    private List<PlayerEntity> tanks;

    private final Color bgColor = new Color(128, 128, 128);
    private final Color textColor = new Color(0, 0, 0);

    private int ticks = 0;

    private TileManager tileManager;
    private Tile grassTile;
    private Tile brickTile;

    public GameViewPanel(List<PlayerEntity> tanks) {
        Dimension dimension = new Dimension();
        dimension.width = SIZE;
        dimension.height = SIZE;
        this.setPreferredSize(dimension);
        this.tanks = tanks;
        this.tileManager = new TileManager();
        this.grassTile = new Tile(tileManager, 1, 0, 0);
        this.brickTile = new Tile(tileManager, 2, 1, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, SIZE, SIZE);
        grassTile.render(g);
        brickTile.render(g);
        //System.out.printf("Rendering frame, %d tanks\n", tanks.size());
        for (PlayerEntity playerEntity : tanks) {
            playerEntity.render(g);
        }
        g.setColor(textColor);
        g.drawString(String.valueOf(ticks++), 10, 10);
    }

    public List<PlayerEntity> getTanks() {
        return tanks;
    }
}
