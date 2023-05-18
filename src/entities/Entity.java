package entities;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import main.GamePanel;

public abstract class Entity {
    
    protected float x,y;
    float width, height;
    protected boolean isDebuging = false;
    protected Rectangle2D.Float hitbox;

    public Entity(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        //initHitbox();
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
}   
