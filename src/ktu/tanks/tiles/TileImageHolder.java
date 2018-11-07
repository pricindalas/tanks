package ktu.tanks.tiles;

import java.awt.image.BufferedImage;

public class TileImageHolder {
    private BufferedImage image;
    private int tileId;

    public TileImageHolder(BufferedImage image, int tileId) {
        this.image = image;
        this.tileId = tileId;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getTileId() {
        return tileId;
    }
}
