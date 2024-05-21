package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import static utils.HelpMethods.*;

import levels.LevelManager;
import main.Game;
import java.awt.image.BufferedImage;
import utils.LoadSave;

public abstract class Entity {

    protected Rectangle2D.Float hitbox;
    private float width, height;
    private float xSpeed = 1, ySpeed;
    // TODO
    private int action;
    private String[] actions;
    private boolean moving;
    private String movingDirection;
    private boolean left, right, up, down;
    private LevelManager lm;

    private int animationTick = 0;
    private int ticksPerFrame = 3;
    private int animationIndex = 0;
    private int animationSpeed = (144 * 1 / ticksPerFrame);
    private BufferedImage img;
    public BufferedImage[][] animations;

    private float xDrawOffset = 0;
    private float yDrawOffset = 15 * Game.SCALE;
    private String atlas;

    // TODO level manager verify pos

    public Entity(
            float x, float y,
            float width, float height,
            LevelManager lm, String atlas) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
        this.width = width;
        this.height = height;
        this.atlas = atlas;
        this.lm = lm;
    }

    protected void drawHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    protected void updatePosition() {

        if (!left && !right && !up && !down)
            return;

        float speed = 0, ySpeed = 0;

        if (left && !right)
            speed = -xSpeed;
        else if (right && !left)
            speed = xSpeed;
        if (up && !down)
            ySpeed = -xSpeed;
        else if (down && !up)
            ySpeed = xSpeed;

        if (canMove((hitbox.x + speed), (hitbox.y + ySpeed), hitbox.width, hitbox.height, lm)) {
            hitbox.x += speed;
            hitbox.y += ySpeed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(
                animations[action][animationIndex],
                (int) (hitbox.x - xDrawOffset),
                (int) (hitbox.y - yDrawOffset),
                (int) width, (int) height,
                null);
        drawHitbox(g);
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

            if (animationIndex >= 3)
                animationIndex = 0;
        }
    }

    public void load() {

        int ImageWidth = 48, ImageHeight = 64;
        img = LoadSave.GetSprite(atlas);
        animations = new BufferedImage[4][3];

        for(int line = 0; line < animations.length; line++) {
            for(int column = 0; column < animations[line].length; column++) {
                animations[line][column] = img.getSubimage (
                    column * ImageWidth, line * ImageHeight, ImageWidth, ImageHeight
                );
            }
        }
    }

    public void setDirection(int v) {
        this.action = v;
    }

    public boolean isLeft() {
        return left;
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public boolean isRight() {
        return right;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isDown() {
        return down;
    }

    public void setDown(boolean down) {
        this.down = down;
    }
}
