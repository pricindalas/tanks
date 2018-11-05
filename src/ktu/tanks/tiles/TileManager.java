package ktu.tanks.tiles;

import ktu.tanks.util.ImageLoader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class TileManager {

    private List<TileImageHolder> tiles;
    private BufferedImage emptyImage;
    public TileManager() {
        loadResources();
    }    private void loadResources() {
        tiles = new ArrayList<>();
        tiles.add(new TileImageHolder(ImageLoader.loadImage("tiles/grass-1.png"), 1));
        tiles.add(new TileImageHolder(ImageLoader.loadImage("tiles/brick-1.png"), 2));
        tiles.add(new TileImageHolder(ImageLoader.loadImage("tiles/dirt-1.png"), 3));
        tiles.add(new TileImageHolder(ImageLoader.loadImage("tiles/water-1.png"), 4));
        emptyImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
    }

    public BufferedImage getTileImage(int tileId) {
        for (TileImageHolder tile : tiles) {
            if (tile.getTileId() == tileId) {
                return tile.getImage();
            }
        }
        return emptyImage;
    }
}
