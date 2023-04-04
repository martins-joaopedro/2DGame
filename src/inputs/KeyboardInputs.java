package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.Game;
import main.GamePanel;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;
    private Game game;

    public KeyboardInputs(GamePanel g, Game game) {
        this.gamePanel = g;
        this.game = game;
    }

    @Override
    public void keyPressed(KeyEvent e) {

        // System.out.println("APERTOU");
        switch (e.getKeyCode()) {

            case KeyEvent.VK_W:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                game.getPlayer().changeDirection(0);
                game.getPlayer().changeYPosition(-10);
                break;

                case KeyEvent.VK_D:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                game.getPlayer().changeDirection(1);
                game.getPlayer().changeXPosition(+10);
                break;

            case KeyEvent.VK_S:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                game.getPlayer().changeDirection(2);
                game.getPlayer().changeYPosition(+10);
                break;

            case KeyEvent.VK_A:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                game.getPlayer().changeDirection(3);
                game.getPlayer().changeXPosition(-10);
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
    }

}
