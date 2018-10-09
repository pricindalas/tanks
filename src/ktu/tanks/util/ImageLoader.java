package ktu.tanks.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class ImageLoader {
    public static BufferedImage loadImage(String res) {
        URL url = ImageLoader.class.getClassLoader().getResource(res);

        if (url == null)
            return null;

        BufferedImage image = null;

        try {
            image = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println("Error. Could not load file " + res);
            e.printStackTrace();
        }

        return image;
    }
}
