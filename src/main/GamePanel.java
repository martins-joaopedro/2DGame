package main;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GamePanel extends JPanel  {

    private MouseInputs mouseInputs;
    private int x = 0, y = 0;

    public GamePanel() {   
        
        mouseInputs = new MouseInputs(this);

        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    public void changeXPosition(int v) {
        this.x += v;
        repaint();
    }

    public void changeYPosition(int v) {
        this.y += v;
        repaint();
    }

    public void dragRectangle(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }   

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillArc(x, y, 100, 100, 30, 360);
    }
}
