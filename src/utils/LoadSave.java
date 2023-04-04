package utils;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

public class LoadSave {
    public static final String PLAYER_ATLAS = "dodo.png";
    public static final String LEVEL_ATLAS = "level.png";

    public static BufferedImage GetSprite(String path) {
        BufferedImage img = null;
        InputStream is = LoadSave.class.getResourceAsStream("/res/" + path);

        try {
            img = ImageIO.read(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return img;
    }
}
