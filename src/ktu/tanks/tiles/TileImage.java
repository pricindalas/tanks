package ktu.tanks.tiles;

import java.awt.image.BufferedImage;

public abstract class TileImage {

    protected BufferedImage image;

    public TileImage(String resource) {

    }

    public BufferedImage getImage() {
        return image;
    }
}
