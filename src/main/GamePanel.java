package main;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static main.Game.GAME_HEIGHT;
import static main.Game.GAME_WIDTH;;

public class GamePanel extends JPanel  {

    private MouseInputs mouseInputs;
    private KeyboardInputs keyboardInputs;
    
    ////////////////////////// -> temporario
    private Game game;

    public GamePanel(Game game) {   
        
        this.game = game;

        keyboardInputs = new KeyboardInputs(this, game);
        mouseInputs = new MouseInputs(this);

        setPanelSize(); 
        addKeyListener(keyboardInputs);
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
    }

    private void setPanelSize() {
        Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
        setPreferredSize(size);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.render(g);
    }
}
