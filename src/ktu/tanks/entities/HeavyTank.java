package ktu.tanks.entities;

import ktu.tanks.entities.base.Tank;
import ktu.tanks.util.ImageLoader;

public class HeavyTank extends Tank {

    @Override
    protected void loadImages() {
        this.imgUp = ImageLoader.loadImage("tank/t1n.png");
        this.imgDown = ImageLoader.loadImage("tank/t1s.png");
        this.imgLeft = ImageLoader.loadImage("tank/t1w.png");
        this.imgRight = ImageLoader.loadImage("tank/t1e.png");
    }
}
