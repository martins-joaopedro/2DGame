package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;

public class KeyboardInputs implements KeyListener {

    public static final int UP = 0;
    public static final int DOWN = 2;
    public static final int LEFT = 3;
    public static final int RIGHT = 1;

    private GamePanel gamePanel;
    private Game game;

    public KeyboardInputs(GamePanel g, Game game) {
        this.gamePanel = g;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                game.getPlayer().setDirection(UP);
                game.getPlayer().setUp(true);
                break;

                case KeyEvent.VK_D:         
                game.getPlayer().setDirection(RIGHT);
                game.getPlayer().setRight(true);
                break;

            case KeyEvent.VK_S:        
                game.getPlayer().setDirection(DOWN);
                game.getPlayer().setDown(true);
                break;

            case KeyEvent.VK_A:
                game.getPlayer().setDirection(LEFT);
                game.getPlayer().setLeft(true);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                game.getPlayer().setUp(false);
                break;

                case KeyEvent.VK_D:         
                game.getPlayer().setRight(false);
                break;

            case KeyEvent.VK_S:       
                game.getPlayer().setDown(false);
                break;

            case KeyEvent.VK_A:
                game.getPlayer().setLeft(false);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}
