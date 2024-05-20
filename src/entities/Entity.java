package entities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import static utils.HelpMethods.canMove;
import static utils.Constants.PlayerConstants.*;

import levels.LevelManager;

public abstract class Entity {
    
    protected float x,y;
    float width, height;
    protected boolean isDebuging = true;
    protected Rectangle2D.Float hitbox;
    private boolean left, right, up, down;
    private int playerSpeed = 1;

    //TODO game method to verify the pos
    private int[][] lvlData; 

    public Entity(float x, float y, float width, float height, LevelManager lm) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.lvlData = lm.getCurrentLevel().getLevelData();

        initHitbox(x, y, width, height);
    } 

    protected void initHitbox(float x, float y, float width, float height) {
        hitbox = new Rectangle2D.Float(x, y, width, height);
    }

    public void setDebugingState(boolean state) {
        this.isDebuging = state;
    }

    protected void drawHitbox(Graphics g) {
        //Debug hitbox
        if(isDebuging) {
            g.setColor(Color.PINK);
            g.drawRect((int) hitbox.x, (int) hitbox.y, (int) hitbox.width, (int) hitbox.height);
        }
    }

    public Rectangle2D.Float getHitbox() {
        return hitbox;
    }

    protected void updatePosition() {

        if(!left && !right && !up && !down)
            return;

        float xSpeed = 0, ySpeed = 0;

        if(left && !right)
            xSpeed = -playerSpeed;
        else if(right && !left)
            xSpeed = playerSpeed;
        if(up && !down)
            ySpeed = -playerSpeed;
        else if(down && !up)
            ySpeed = playerSpeed;

        if(canMove((hitbox.x + xSpeed), (hitbox.y + ySpeed), hitbox.width, hitbox.height, lvlData)) {
            hitbox.x += xSpeed;
            hitbox.y += ySpeed;
        }
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
