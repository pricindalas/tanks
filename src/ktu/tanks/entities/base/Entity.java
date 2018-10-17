package ktu.tanks.entities.base;

import ktu.tanks.Direction;
import ktu.tanks.decorators.Renderable;

import java.awt.image.BufferedImage;

public abstract class Entity implements Renderable {
    protected BufferedImage imgUp;
    protected BufferedImage imgDown;
    protected BufferedImage imgLeft;
    protected BufferedImage imgRight;

    protected Direction direction;

    private boolean isMoving;

    protected int health;
    protected int x;
    protected int y;
    protected int movementSpeed;

    public Entity() {
        loadImages();
    }

    protected abstract void loadImages();

    public void tick() {
        if (isMoving) {
            switch (direction) {
                case Up:
                    y -= movementSpeed;
                    break;
                case Down:
                    y += movementSpeed;
                    break;
                case Left:
                    x -= movementSpeed;
                    break;
                case Right:
                    x += movementSpeed;
                    break;
            }
        }
    }

    protected BufferedImage getImage() {
        switch (direction) {
            case Up:
                return imgUp;
            case Down:
                return imgDown;
            case Left:
                return imgLeft;
            case Right:
                return imgRight;
        }

        return null;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

}
