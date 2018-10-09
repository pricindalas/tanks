package ktu.tanks.ui;

import ktu.tanks.Direction;
import ktu.tanks.util.ImageLoader;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.nio.file.FileAlreadyExistsException;

public class Tank {

    private BufferedImage imgUp;
    private BufferedImage imgDown;
    private BufferedImage imgLeft;
    private BufferedImage imgRight;

    private Direction direction;
    private boolean isMoving;

    private int x, y, movementSpeed;

    public Tank(int x, int y, Direction direction, int movementSpeed) {
        this.imgUp = ImageLoader.loadImage("tank/t1n.png");
        this.imgDown = ImageLoader.loadImage("tank/t1s.png");
        this.imgLeft = ImageLoader.loadImage("tank/t1w.png");
        this.imgRight = ImageLoader.loadImage("tank/t1e.png");

        this.x = x;
        this.y = y;
        this.direction = direction;
        this.movementSpeed = movementSpeed;
    }

    public void setMoving(boolean isMoving) {
        this.isMoving = isMoving;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setDirection(Direction direction) {
        if (direction == null)
            return;

        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void move(Direction direction, int amount) {
        this.direction = direction;

        switch (direction) {
            case Up:
                this.y -= amount;
                break;
            case Down:
                this.y += amount;
                break;
            case Left:
                this.x -= amount;
                break;
            case Right:
                this.x += amount;
                break;
        }
    }

    private BufferedImage getImage() {
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

    public void render(Graphics g) {
        g.drawImage(getImage(), x, y, null);
    }

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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
