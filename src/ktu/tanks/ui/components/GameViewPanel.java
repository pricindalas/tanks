package ktu.tanks.ui.components;

import ktu.tanks.entities.*;
import ktu.tanks.entities.base.Tank;
import ktu.tanks.health.Health;
import ktu.tanks.health.HealthManager;
import ktu.tanks.iterator.PlayerConcreteContainer;
import ktu.tanks.iterator.PlayerIterator;
import ktu.tanks.models.Player;
import ktu.tanks.tiles.Tile;
import ktu.tanks.tiles.TileManager;
import ktu.tanks.ui.Viewport;
import ktu.tanks.visitor.DistanceCalcInMeters;
import ktu.tanks.visitor.DistanceCalcInPixels;
import ktu.tanks.visitor.Visitor;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameViewPanel extends JComponent {

    private static final int SIZE = 512;

    private List<PlayerEntity> players;
    private List<Health> healths;
    private List<Tile> tiles;

    private PlayerConcreteContainer playerConcreteContainer;

    private final Color bgColor = new Color(96, 96, 128);
    private final Color textColor = new Color(0, 0, 0);

    private int ticks = 0;

    private Visitor distanceCalcInPixels;
    private Visitor distanceCalcInMeters;

    private Viewport viewport;
    private TileManager tileManager;
    private HealthManager healthManager;

    private Health healthPrototype;

    public GameViewPanel(List<PlayerEntity> players) {
        Dimension dimension = new Dimension();
        dimension.width = SIZE;
        dimension.height = SIZE;
        this.setPreferredSize(dimension);
        this.players = players;
        this.viewport = new Viewport(SIZE, SIZE);
        this.tileManager = new TileManager();
        this.tiles = new ArrayList<>();

        this.healthManager = new HealthManager();
        this.healths = new ArrayList<>();
        healthPrototype = new Health(1);

        this.distanceCalcInPixels = new DistanceCalcInPixels(viewport);
        this.distanceCalcInMeters = new DistanceCalcInMeters(viewport);

        this.playerConcreteContainer = new PlayerConcreteContainer();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.setColor(bgColor);
        g.fillRect(0, 0, SIZE, SIZE);

        for (Tile tile : tiles) {
            tile.render(g, viewport);
        }

        for (Health health : healths) {
            health.render(g, viewport);
        }

        for (PlayerEntity playerEntity : players) {
            playerEntity.render(g, viewport);
        }

        g.setColor(textColor);
        g.drawString("X: " + viewport.getX() + " Y: " + viewport.getY() + " Frame: " + ticks++, 10, 10);
        g.drawString("Logged Users: ", 10, 25);

        int yHeight = 15;
        for(PlayerIterator iter = playerConcreteContainer.getIterator(); iter.hasNext();){
            Player player = iter.next();
            g.drawString(String.format("-> %s\t[dst: %dpx, %dm]", player.getName(), player.accept(distanceCalcInPixels), player.accept(distanceCalcInMeters)), 10, 25 + yHeight);
            yHeight +=12;
        }
    }

    public List<PlayerEntity> getPlayers() {
        return players;
    }

    public Viewport getViewport() {
        return viewport;
    }

    public void setNameIterator(PlayerConcreteContainer nameContainer){
        this.playerConcreteContainer = nameContainer;
    }

    public void setTiles(Tile[] tiles) {
        this.tiles.clear();
        for (Tile tile : tiles) {
            tile.setTileManager(tileManager);
            this.tiles.add(tile);
        }
    }

    public void attackTank(){

    }

    public void setHealths(List<Health> healths) {
        this.healths = healths;
        for (Health health : healths) {
            health.setHealthManager(healthManager);
            health.incTime();
//            if(health.getTime() > 2){
//                this.healths.remove(health);
//            }
        }
    }

    public List<Health> getHealths(){
        return healths;
    }

    public Health getHealthPrototype(){
        return healthPrototype;
    }
}
