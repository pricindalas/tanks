package ktu.tanks.health;

import java.awt.image.BufferedImage;

public class HealthHolder {
    private BufferedImage image;
    private int healthId;

    public HealthHolder(BufferedImage image, int healthId) {
        this.image = image;
        this.healthId = healthId;
    }

    public BufferedImage getImage() {
        return image;
    }

    public int getHealthId() {
        return healthId;
    }
}
