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
                game.notifyKeyPressedEvent("UP");
                break;

                case KeyEvent.VK_D:         
                game.notifyKeyPressedEvent("RIGHT");
                break;

            case KeyEvent.VK_S:        
                game.notifyKeyPressedEvent("DOWN");
                break;

            case KeyEvent.VK_A:
                game.notifyKeyPressedEvent("LEFT");
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                game.notifyKeyReleasedEvent("UP");
                break;

            case KeyEvent.VK_D:         
                game.notifyKeyReleasedEvent("RIGHT");
                break;

            case KeyEvent.VK_S:        
                game.notifyKeyReleasedEvent("DOWN");
                break;

            case KeyEvent.VK_A:
                game.notifyKeyReleasedEvent("LEFT");
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}
