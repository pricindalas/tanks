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

    }

    @Override
    public int getHealth() {
        return playerEntity.getPlayerEntity().getHealth();
    }

    @Override
    public void setHealth(int health) {

    }

    @Override
    public int getPosX() {
        return playerEntity.getPlayerEntity().getX();
    }

    @Override
    public void setPosX(int posX) {

    }

    @Override
    public int getPosY() {
        return playerEntity.getPlayerEntity().getY();
    }

    @Override
    public void setPosY(int posY) {

    }

    @Override
    public Direction getDirection() {
        return playerEntity.getPlayerEntity().getDirection();
    }

    @Override
    public void setDirection(Direction direction) {

    }

    @Override
    public int getLives() {
        return playerEntity.getLives();
    }

    @Override
    public void setLives(int lives) {

    }
}
