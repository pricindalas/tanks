package ktu.tanks.adapters;

import ktu.tanks.Direction;
import ktu.tanks.entities.PlayerEntity;
import ktu.tanks.models.Player;

public class PlayerAdapter extends Player {

    private PlayerEntity playerEntity;

    public PlayerAdapter(PlayerEntity playerEntity) {
        this.playerEntity = playerEntity;
    }

    @Override
    public String getName() {
        return playerEntity.getPlayerName();
    }

    @Override
    public void setName(String name) {
        playerEntity.setPlayerName(name);
    }

    @Override
    public int getHealth() {
        return playerEntity.getEntity().getHealth();
    }

    @Override
    public void setHealth(int health) {
        playerEntity.getEntity().setHealth(health);
    }

    @Override
    public int getPosX() {
        return playerEntity.getEntity().getX();
    }

    @Override
    public void setPosX(int posX) {
        playerEntity.getEntity().setX(posX);
    }

    @Override
    public int getPosY() {
        return playerEntity.getEntity().getY();
    }

    @Override
    public void setPosY(int posY) {
        playerEntity.getEntity().setY(posY);
    }

    @Override
    public Direction getDirection() {
        return playerEntity.getEntity().getDirection();
    }

    @Override
    public void setDirection(Direction direction) {
        playerEntity.getEntity().setDirection(direction);
    }

    @Override
    public int getLives() {
        return playerEntity.getLives();
    }

    @Override
    public void setLives(int lives) {
        playerEntity.setLives(lives);
    }
}
