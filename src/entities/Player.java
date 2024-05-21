package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.LevelManager;
import main.Game;
import utils.LoadSave;
import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private int playerAction = LEFT_WALKING;
    private LoadSave l = new LoadSave();
    private String atlas = l.PLAYER_ATLAS;
    
    public Player(float x, float y, float width, float height, LevelManager lm) {
        super(x, y, 2f, width, height, lm, "dodo.png");
        load();
        //initHitbox(x, y, 42*Game.SCALE, 48*Game.SCALE);
    }
    
}
