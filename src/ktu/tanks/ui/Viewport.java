package ktu.tanks.ui;


import com.fasterxml.jackson.annotation.JsonIgnore;
import ktu.tanks.converters.PositionConverter;

import java.util.ArrayList;
import java.util.List;

public class Viewport {
    private int width;
    private int height;
    private int x;
    private int y;

    @JsonIgnore
    private int indX;

    @JsonIgnore
    private int indY;

    @JsonIgnore
    private List<ViewportObserver> observers;

    public Viewport(int width, int height) {
        this.width = width;
        this.height = height;
        observers = new ArrayList<>();
    }

    public void attachObserver(ViewportObserver observer) {
        this.observers.add(observer);
    }

    public void detachObserver(ViewportObserver observer) {
        this.observers.remove(observer);
    }

    private void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public void moveTo(int posX, int posY) {
        int dx = posX - this.x;
        int dy = posY - this.y;

        setX(this.x + dx / 10);
        setY(this.y + dy / 10);
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
        int indX = this.indX;
        this.indX = PositionConverter.PosToInd(x);

        if (this.indX != indX) {
            notifyObservers();
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
        int indY = this.indY;
        this.indY = PositionConverter.PosToInd(y);

        if (this.indY != indY) {
            notifyObservers();
        }
    }

    public int getIndX() {
        return indX;
    }

    public int getIndY() {
        return indY;
    }

    public int transformX(int x) {
        return x - this.x + width / 2;
    }

    public int transformY(int y) {
        return y - this.y + height / 2;
    }
}
