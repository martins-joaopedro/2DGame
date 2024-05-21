package main;

import java.awt.Graphics;

import entities.player.Player;
import entities.player.PlayerEvents;
import levels.LevelManager;
import observer.Event;
import observer.NotificationService;

public class Game implements Runnable {

    public final static int TILES_DEFAULT_SIZE = 32;
    public final static float SCALE = 1.0f;
    public final static int TILES_IN_WIDTH = 26;
    public final static int TILES_IN_HEIGHT = 14;
    public final static int TILES_SIZE = (int) (TILES_DEFAULT_SIZE * SCALE);
    public final static int GAME_WIDTH = TILES_SIZE * TILES_IN_WIDTH;
    public final static int GAME_HEIGHT = TILES_SIZE * TILES_IN_HEIGHT;

    private Window gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;
    private final int FPS_SET = 144;
    private final int UPS_SET = 200;

    private NotificationService service;
    private LevelManager lm;
    private Player p;

    public Game() {

        service = new NotificationService();
        initializeClasses();

        gamePanel = new GamePanel(this);
        gameWindow = new Window(gamePanel);

        gamePanel.setFocusable(true);
        gamePanel.requestFocus();
        startGameLoop();
    }

    private void initializeClasses() {
        lm = new LevelManager(this);
        p = new Player(50, 200, (int) 42 * SCALE, (int) 48 * SCALE);

        for(Event event : Event.values())
            service.subscribe(event, p);
    }

    private void startGameLoop() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void update() {
        p.update();
    }

    public void render(Graphics g) {
        lm.draw(g);
        p.render(g);
    }

    public Player getPlayer() {
        return this.p;
    }

    public NotificationService getService() {
        return this.service;
    }

    @Override
    public void run() {

        double timePerFrame = 1000000000.0 / FPS_SET;
        double timePerUpdate = 1000000000.0 / UPS_SET;

        long lastCheck = System.currentTimeMillis();
        long previousTime = System.nanoTime();

        int frames = 0;
        int updates = 0;
        double deltaU = 0, deltaF = 0;

        while (true) {

            long currentTime = System.nanoTime();

            deltaF += (currentTime - previousTime) / timePerFrame;
            deltaU += (currentTime - previousTime) / timePerUpdate;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            // MAIN MACHINE -> Checks every second and makes everything to update
            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                // System.out.println("FPS " + frames + "| UPS: " + updates);
                updates = 0;
                frames = 0;
            }
        }
    }
}
