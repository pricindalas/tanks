package ktu.tanks.tiles;

import ktu.tanks.util.ImageLoader;

import java.awt.image.BufferedImage;

public class TileManager {

    private TileImageHolder grass1;
    private TileImageHolder brick1;
    private TileImageHolder dirt1;
    private TileImageHolder water1;

//    private BufferedImage tile1;
//    private BufferedImage tile2;
//    private BufferedImage tile3;
//    private BufferedImage tile4;
//    private BufferedImage tile5;

    private TileImageHolder emptyImage;

    public TileManager() {
        loadResources();
    }

    private void loadResources() {
        grass1 = new TileImageHolder(ImageLoader.loadImage("tiles/grass-1.png"), 1);
        brick1 = new TileImageHolder(ImageLoader.loadImage("tiles/brick-1.png"), 2);
        dirt1 = new TileImageHolder(ImageLoader.loadImage("tiles/dirt-1.png"), 3);
        water1 = new TileImageHolder(ImageLoader.loadImage("tiles/water-1.png"), 4);
        emptyImage = new NullTileImageHolder();

//        tile1 = ImageLoader.loadImage("tiles/tile1.png");
//        tile2 = ImageLoader.loadImage("tiles/tile2.png");
//        tile3 = ImageLoader.loadImage("tiles/tile3.png");
//        tile4 = ImageLoader.loadImage("tiles/tile4.png");
//        tile5 = ImageLoader.loadImage("tiles/tile5.png");

        //emptyImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
    }

    TileImageHolder getTileImage(int tileId) {
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
