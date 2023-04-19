package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import main.Game;
import utils.LoadSave;
import static utils.HelpMethods.canMove;
import static utils.Constants.PlayerConstants.*;

public class Player extends Entity {

    private int tickPerFrame = 3;
    private int animationTick = 0, animationIndex = 0, animationSpeed = (144 * 1 / tickPerFrame);

    private BufferedImage img;
    private BufferedImage[][] animations;

    private int playerAction = LEFT_WALKING;
    private LoadSave l = new LoadSave();
    private int[][] levelData;

    private boolean debuging = true;

    private float xDrawOffset = 0*Game.SCALE;
    private float yDrawOffset = 0sad*Game.SCALE;

    public Player(float x, float y, float width, float height) {
        super(x, y, width, height);
        load();
        initHitbox(x, y, 48*Game.SCALE, 48*Game.SCALE);
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

    public void loadLevelData(int[][] levelData) {
        this.levelData = levelData;
        printLevelData();
    }

    public void render(Graphics g) {
        g.drawImage(animations[playerAction][animationIndex], (int)(hitbox.x - xDrawOffset), (int)(hitbox.y - yDrawOffset), (int)width, (int)height, null);
        drawHitbox(g);
    }

    public void printLevelData() {
        System.out.println("DEBUGANDO");
        for(int i=0; i<levelData.length; i++) {
            for(int j=0; j<levelData[i].length; j++) {
                System.out.print(levelData[i][j] + " ");
            }
            System.out.println();
        }        
    }

    public void changeXPosition(int x) {
        if(canMove(hitbox.x + x, hitbox.y, width, height, levelData))
            hitbox.x += x;
    }

    public void changeYPosition(int y) {
        if(canMove(hitbox.x, hitbox.y + y, width, height, levelData))
            hitbox.y += y;
    }

    public void changeDirection(int v) {
        this.playerAction = v;
    }
}
