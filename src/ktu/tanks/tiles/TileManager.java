package ktu.tanks.tiles;

import ktu.tanks.util.ImageLoader;

import java.awt.image.BufferedImage;

public class TileManager {

    private BufferedImage grass1;
    private BufferedImage brick1;
    private BufferedImage dirt1;
    private BufferedImage water1;
    private BufferedImage emptyImage;

    public TileManager() {
        loadResources();
    }

    private void loadResources() {
        grass1 = ImageLoader.loadImage("tiles/grass-1.png");
        brick1 = ImageLoader.loadImage("tiles/brick-1.png");
        dirt1 = ImageLoader.loadImage("tiles/dirt-1.png");
        water1 = ImageLoader.loadImage("tiles/water-1.png");
        emptyImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
    }

    BufferedImage getTileImage(int tileId) {
        switch (tileId) {
            case 1:
                return grass1;
            case 2:
                return brick1;
            case 3:
                return dirt1;
            case 4:
                return water1;
            default:
                return emptyImage;
        }
    }
}
