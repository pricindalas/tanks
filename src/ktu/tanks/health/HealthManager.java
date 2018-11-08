package ktu.tanks.health;

import ktu.tanks.util.ImageLoader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class HealthManager {

    private List<HealthHolder> healths;
    private BufferedImage emptyImage;

    public HealthManager() {
        loadResources();
    }

    private void loadResources() {
        healths = new ArrayList<>();
        healths.add(new HealthHolder(ImageLoader.loadImage("mush.png"), 1));
//        healths.add(new HealthHolder(ImageLoader.loadImage("tiles/water-1.png"), 2));
        emptyImage = new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB);
    }

    BufferedImage getHealthImage(int healthId) {
        for (HealthHolder health : healths) {
            if (health.getHealthId() == healthId) {
                return health.getImage();
            }
        }
        return emptyImage;
    }
}
