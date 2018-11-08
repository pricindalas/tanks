package ktu.tanks.tiles;

import ktu.tanks.util.ImageLoader;

import java.awt.image.BufferedImage;

public class TileManager {

    private BufferedImage grass1;
    private BufferedImage brick1;
    private BufferedImage dirt1;
    private BufferedImage water1;

    private BufferedImage tile1;
    private BufferedImage tile2;
    private BufferedImage tile3;
    private BufferedImage tile4;
    private BufferedImage tile5;

    private BufferedImage emptyImage;

    public TileManager() {
        loadResources();
    }

    private void loadResources() {
        grass1 = ImageLoader.loadImage("tiles/grass-1.png");
        brick1 = ImageLoader.loadImage("tiles/brick-1.png");
        dirt1 = ImageLoader.loadImage("tiles/dirt-1.png");
        water1 = ImageLoader.loadImage("tiles/water-1.png");

        tile1 = ImageLoader.loadImage("tiles/tile1.png");
        tile2 = ImageLoader.loadImage("tiles/tile2.png");
        tile3 = ImageLoader.loadImage("tiles/tile3.png");
        tile4 = ImageLoader.loadImage("tiles/tile4.png");
        tile5 = ImageLoader.loadImage("tiles/tile5.png");

        emptyImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
    }

    BufferedImage getTileImage(int tileId) {
        switch (tileId) {
            case 1:
                return tile1;
            case 2:
                return tile2;
            case 3:
                return tile3;
            case 4:
                return tile4;
            case 5:
                return tile5;
            default:
                return emptyImage;
        }
    }
}
