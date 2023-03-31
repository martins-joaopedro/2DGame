package main;

public class Game {

    private Window gameWindow;
    private GamePanel gamePanel;

    public Game() {
        gamePanel = new GamePanel();
        gameWindow = new Window(gamePanel);
        gamePanel.requestFocus();
    }
}
