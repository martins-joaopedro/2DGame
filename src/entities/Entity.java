package entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import static utils.HelpMethods.*;

import levels.LevelManager;
import main.Game;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

import utils.LoadSave;

public abstract class Entity {

    protected float x, y;
    protected Rectangle2D.Float hitbox;
    private float width, height;
    private float xSpeed, ySpeed;
    // TODO
    private int action;
    private String[] actions;
    protected Map<String, Boolean> movements;
    private boolean moving;
    private String movingDirection;
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
            float xSpeed,
            float width, float height,
            LevelManager lm, String atlas) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
        this.x = x;
        this.y = y;
        this.xSpeed = xSpeed;
        this.width = width;
        this.height = height;
        this.atlas = atlas;
        this.lm = lm;
        this.movements = new HashMap<>();
        startMovements();
    }

    public void startMovements() {
        String[] allowedMoves = {"UP", "DOWN", "LEFT", "RIGHT"};
        for(String s : allowedMoves)
            this.movements.put(s, false);
    }

    protected void drawHitbox(Graphics g) {
        g.setColor(Color.RED);
        g.drawRect((int) x, (int) y, (int) hitbox.width, (int) hitbox.height);
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    protected void updatePosition() {

        float speed = 0, ySpeed = 0;

        if(movements.get("LEFT") && !movements.get("RIGHT"))
            speed = -xSpeed;

        else if(movements.get("RIGHT") && !movements.get("LEFT"))
            speed = xSpeed;

        if (movements.get("UP") && !movements.get("DOWN"))
            ySpeed = -xSpeed;

        else if (movements.get("DOWN") && !movements.get("UP"))
            ySpeed = xSpeed; 

        if (canMove((hitbox.x + speed), (hitbox.y + ySpeed), hitbox.width, hitbox.height, lm)) {
            x += speed;
            y += ySpeed;
        }
    }

    public void render(Graphics g) {
        g.drawImage(
                animations[action][animationIndex],
                (int) (x - xDrawOffset),
                (int) (y - yDrawOffset),
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

}
