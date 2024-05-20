package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import levels.LevelManager;
import main.Game;
import utils.LoadSave;
import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private int tickPerFrame = 3;
    private int animationTick = 0, animationIndex = 0, animationSpeed = (144 * 1 / tickPerFrame);

    private BufferedImage img;
    private BufferedImage[][] animations;

    private int playerAction = LEFT_WALKING;
    private LoadSave l = new LoadSave();

    private float xDrawOffset = 0;
    private float yDrawOffset = 15*Game.SCALE;

    public Player(float x, float y, float width, float height, LevelManager lm) {
        super(x, y, width, height, lm);
        load();
        initHitbox(x, y, 42*Game.SCALE, 48*Game.SCALE);
    }

    public void load() {
        img = l.GetSprite(LoadSave.PLAYER_ATLAS);

        int ImageWidth = 48, ImageHeight = 64;

        animations = new BufferedImage[4][3];

        for (int line = 0; line < animations.length; line++) {
            for (int column = 0; column < animations[line].length; column++) {
                animations[line][column] = img.getSubimage(column * ImageWidth, line * ImageHeight, ImageWidth, ImageHeight);
            }
        }
    }

    public void update() {
        updatePosition();
        updateAnimationTick();
    }

    public void updateAnimationTick() {
        animationTick++;

        if (animationTick >= animationSpeed) {

            animationTick = 0;
            animationIndex++;

            if (animationIndex >= GetSprintAmount(playerAction))
                animationIndex = 0;
        }
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset), (int)width, (int)height, null);
        drawHitbox(g);
    }

    public void setDirection(int v) {
        this.playerAction = v;
    }
}
