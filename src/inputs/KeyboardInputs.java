package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GamePanel;

public class KeyboardInputs implements KeyListener {

    private GamePanel gamePanel;

    public KeyboardInputs(GamePanel g) {
        this.gamePanel = g;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_A:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                gamePanel.changeXPosition(-10);
            break;
            
            case KeyEvent.VK_W:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                gamePanel.changeYPosition(10);
                break;
            
            case KeyEvent.VK_S:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                gamePanel.changeYPosition(-10);
            break;
            
            case KeyEvent.VK_D:
                System.out.println("A tecla " + e.getKeyChar() + " foi pressionada");
                gamePanel.changeXPosition(10);
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
