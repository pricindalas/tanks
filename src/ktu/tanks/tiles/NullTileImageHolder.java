package ktu.tanks.tiles;

import java.awt.image.BufferedImage;

public class NullTileImageHolder extends TileImageHolder {

    public NullTileImageHolder() {
        super(new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB), 0);
    }
}
