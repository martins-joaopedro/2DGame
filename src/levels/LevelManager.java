package levels;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;

public class LevelManager {
    
    private Game game;
    private BufferedImage[] levelSprite;
    private Level level1;

    public LevelManager(Game game) {
        this.game = game;
        importSprites();
        level1 = new Level(LoadSave.GetLevelData(LoadSave.LEVEL_ONE_ATLAS));
    }

    public void importSprites() {
        levelSprite = new BufferedImage[48];

        BufferedImage img = LoadSave.GetSprite(LoadSave.LEVEL_ATLAS);

        for(int line = 0; line<4; line++) {
            for( int column = 0; column<12; column++) {
                int i = line*12 + column;
                levelSprite[i] = img.getSubimage(column*32, line*32, 32, 32);
            }
        }
    }

    public void draw(Graphics g) {

        for(int i=0; i<Game.TILES_IN_HEIGHT; i++)
            for(int j=0; j<Game.TILES_IN_WIDTH; j++) {
                int index = level1.GetSpriteIndex(j, i);
                g.drawImage(levelSprite[index], Game.TILES_SIZE * j, Game.TILES_SIZE * i, Game.TILES_SIZE, Game.TILES_SIZE,  null);
            }
    }

    public Level getCurrentLevel() {
        return level1;
    }

}
