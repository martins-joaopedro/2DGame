package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;
import observer.Event;

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
                game.getService().notify(Event.PRESS_UP);
                break;

            case KeyEvent.VK_D:         
                game.getService().notify(Event.PRESS_RIGHT);
                break;

            case KeyEvent.VK_S:        
            game.getService().notify(Event.PRESS_DOWN);
                break;

            case KeyEvent.VK_A:
            game.getService().notify(Event.PRESS_LEFT);
                break;

            case KeyEvent.VK_SPACE:
            game.getService().notify(Event.PRESS_SPACE);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_W:
                game.getService().notify(Event.RELEASE_UP);
                break;

            case KeyEvent.VK_D:         
                game.getService().notify(Event.RELEASE_RIGHT);
                break;

            case KeyEvent.VK_S:        
                game.getService().notify(Event.RELEASE_DOWN);
                break;

            case KeyEvent.VK_A:
                game.getService().notify(Event.RELEASE_LEFT);
                break;

            case KeyEvent.VK_SPACE:
            game.getService().notify(Event.RELEASE_SPACE);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}
