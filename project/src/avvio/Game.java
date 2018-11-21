package avvio;

import design.PauseMenu;
import entita.KeyManager;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.concurrent.Semaphore;
import java.util.logging.Level;
import java.util.logging.Logger;
import stati.GameState;
import stati.State;
import world.Assets;
import world.Display;
import world.World;

public class Game implements Runnable {

    private Display display;
    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    //States
    private GameState gameState;
    //private State menuState;
    //Input
    private KeyManager keyManager;

    private Handler handler;
    private Boolean level;
    private boolean isPaused;

    public Game(String title, int width, int height) {
        this.width = width;
        this.height = height;
        this.title = title;
        isPaused = false;
        keyManager = new KeyManager();
    }

    private void init() {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);
        Assets.init();
        // menu di pausa durante il gioco
        // menuState = new MenuState(this);
        handler = new Handler(this);
        gameState = new GameState(handler);
        State.setState(gameState);

    }
    // fai tick dello stato corrente

    private void tick() {
        if (State.getState() != null) {
            State.getState().tick();
        }
    }

    private void render() {
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null) {
            display.getCanvas().createBufferStrategy(3);
            return;
        }
        g = bs.getDrawGraphics();
        //Clear Screen
        g.clearRect(0, 0, width, height);
        //Draw Here!

        if (State.getState() != null) {
            State.getState().render(g);
        }

        //End Drawing!
        bs.show();
        g.dispose();
    }

    @Override
    public void run() {

        init();
        while (running) {
            if(!isPaused)
            {
                System.out.println("Game: tick");
                tick();
                render();
            }
        }
        System.out.println("Game stop");
        stop();
    }

    public KeyManager getKeyManager() {
        return keyManager;
    }

    public synchronized void start() {
        if (running) {
            return;
        }
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop() {
        if (!running) {
            return;
        }
        running = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void pause() {
        System.out.println("Lock pause");
        isPaused = true;
        PauseMenu pm = new PauseMenu(this);
        display.getFrame().setVisible(false);
        pm.setVisible(true);
    }
    
    public void resume() {
         isPaused = false;
         System.out.println(running);
       
        display.getFrame().setVisible(true);
    }

    public World getWorld() {
        return gameState.getWorld();
    }

    protected void setRunning(boolean running) {
        this.running = running;
    }

}
