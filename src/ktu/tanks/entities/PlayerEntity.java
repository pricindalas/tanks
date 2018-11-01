package ktu.tanks.entities;

import ktu.tanks.decorators.Renderable;
import ktu.tanks.entities.base.Entity;

import java.awt.*;

public class PlayerEntity implements Renderable {

    private String playerName;
    private Entity playerEntity;
    private int lives;

    public PlayerEntity(String playerName, Entity entity) {
        this.playerName = playerName;
        this.playerEntity = entity;
        this.lives = 10;
    }

    public String getPlayerName() {
        return playerName;
    }

    public Entity getPlayerEntity() {
        return playerEntity;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    @Override
    public void render(Graphics g) {
        playerEntity.render(g);
    }
}
