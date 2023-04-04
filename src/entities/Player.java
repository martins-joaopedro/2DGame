package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utils.LoadSave;
import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private int tickPerFrame = 3;
    private int animationTick = 0, animationIndex = 0, animationSpeed = (144 * 1 / tickPerFrame);

    private BufferedImage img;
    private BufferedImage[][] animations;

    private int playerAction = LEFT_WALKING;
    private LoadSave l = new LoadSave();

    public Player(int x, int y) {
        super(x, y);
        load();
    }

    public void load() {
        img = l.GetSprite(LoadSave.PLAYER_ATLAS);

        int ImageWidth = 48, ImageHeight = 64;

        animations = new BufferedImage[4][3];

        for (int line = 0; line < animations.length; line++) {
            for (int column = 0; column < animations[line].length; column++) {

                System.out.println(line * ImageWidth);
                System.out.println(column * ImageHeight);

                animations[line][column] = img.getSubimage(column * ImageWidth, line * ImageHeight, ImageWidth, ImageHeight);
            }
        }
    }

    public void update() {
        animationTick++;

        if (animationTick >= animationSpeed) {

            animationTick = 0;
            animationIndex++;

            if (animationIndex >= GetSprintAmount(playerAction))
                animationIndex = 0;
        }
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], x, y, 48 * 3, 64 * 3, null);
    }

    public void changeXPosition(int x) {
        this.x += x;
    }

    public void changeYPosition(int y) {
        this.y += y;
    }

    public void changeDirection(int v) {
        this.playerAction = v;
    }
}
