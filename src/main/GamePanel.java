package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static utils.Constants.PlayerConstants.*;

public class GamePanel extends JPanel  {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    private int tickPerFrame = 5;
    private int x = 0, y = 0, animationTick = 0, animationIndex = 0, animationSpeed = (144 * 1/tickPerFrame);

    private BufferedImage img;
    private BufferedImage[][] animations;

    private int playerAction = LEFT_WALKING;

    public GamePanel() {   
        
        keyboardInputs = new KeyboardInputs(this);
        mouseInputs = new MouseInputs(this);

        importImg();
        loadAnimations();

        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void loadAnimations() {
        int ImageWidth = 48, ImageHeight = 64;
        
        animations = new BufferedImage[4][3];

        for(int line=0; line<animations.length; line++) {
            for(int column=0; column<animations[line].length; column++) {

                System.out.println(line*ImageWidth);
                System.out.println(column*ImageHeight);
         
                animations[line][column] = img.getSubimage(column*ImageWidth, line*ImageHeight, ImageWidth, ImageHeight);
            }   
        }
    }

    private void updateAnimationTick() {

        animationTick++;

        if(animationTick >= animationSpeed) {

            animationTick = 0;
            animationIndex++;

            if(animationIndex >= GetSprintAmount(playerAction))
                animationIndex = 0;
        }  
    }

    private void importImg() {

        InputStream is = getClass().getResourceAsStream("/res/dodo.png");

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
    }

    public void changeXPosition(int v) {
        this.x += v;
    }

    public void changeYPosition(int v) {
        this.y += v;
    }

    public void changeDirection(int v) {
        this.playerAction = v;
    }

    public void dragRectangle(int x, int y) {
        this.x = x;
        this.y = y;
    }   

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        updateAnimationTick();
        g.drawImage(animations[playerAction][animationIndex], x, y, 48*3, 64*3, null);
    }
}
