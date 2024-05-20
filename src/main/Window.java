package main;

import javax.swing.JFrame;

public class Window {

    private JFrame jframe;

    public Window(GamePanel gamePanel) {

        jframe = new JFrame();
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.add(gamePanel);
        jframe.setResizable(false);
        jframe.pack();
        jframe.setVisible(true);
    }
}
