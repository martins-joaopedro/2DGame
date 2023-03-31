package main;

import java.awt.Color;

import javax.swing.JFrame;

public class Window {
    private JFrame jframe;

    public Window(GamePanel gamePanel) {
        jframe = new JFrame();
        jframe.setSize(800, 800);
        jframe.add(gamePanel);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
