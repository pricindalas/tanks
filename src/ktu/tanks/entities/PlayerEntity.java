package ktu.tanks.entities;

import ktu.tanks.decorators.Renderable;
import ktu.tanks.entities.base.Entity;
import ktu.tanks.ui.Viewport;

import java.awt.*;

public class PlayerEntity implements Renderable {

    private String playerName;
    private Entity entity;
    private int lives;

    public PlayerEntity(String playerName, Entity entity) {
        this.playerName = playerName;
        this.entity = entity;
        this.lives = 10;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Entity getEntity() {
        return entity;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void render(Graphics g, Viewport viewport) {
        entity.render(g, viewport);
    }
}
