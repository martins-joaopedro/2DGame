package utils;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import javax.imageio.ImageIO;

import main.Game;

public class LoadSave {
    public static final String PLAYER_ATLAS = "dodo.png";
    public static final String LEVEL_ATLAS = "level.png";
    public static final String LEVEL_ONE_ATLAS = "level_one_data.png";

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

    public static int[][] GetLevelData(String path) {
        int[][] lvlData = new int[Game.TILES_IN_HEIGHT][Game.TILES_IN_WIDTH];
        BufferedImage img = GetSprite(path);
        
        for(int j=0; j<img.getHeight(); j++) {
            for(int i=0; i<img.getWidth(); i++) {
                Color color = new Color(img.getRGB(i, j));
                int value = color.getRed();

                if(value >= 48)
                    value = 0;
                     
                lvlData[j][i] = value;
            }
        }
        return lvlData;
    }
}
