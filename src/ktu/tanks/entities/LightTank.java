package ktu.tanks.entities;

import ktu.tanks.entities.base.Tank;
import ktu.tanks.util.ImageLoader;

public class LightTank extends Tank {

    @Override
    protected void loadImages() {
        this.imgUp = ImageLoader.loadImage("tank/t2n.png");
        this.imgDown = ImageLoader.loadImage("tank/t2s.png");
        this.imgLeft = ImageLoader.loadImage("tank/t2w.png");
        this.imgRight = ImageLoader.loadImage("tank/t2e.png");
    }

}
