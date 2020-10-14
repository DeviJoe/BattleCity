package devijoe.view;



import devijoe.Settings;
import devijoe.controller.ArrowController;
import devijoe.controller.ControlManager;
import devijoe.controller.WASD_Controller;
import devijoe.model.Entity;
import devijoe.model.Player;
import devijoe.utils.Time;

import java.awt.*;

public class GameFrame implements Runnable
{
    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics;
    private Entity player1;
    private Player player2;

    public GameFrame() {
        this.running = false;
        Display.create(800, 600, Settings.TITLE, -16777216, 3);
        this.graphics = Display.getGraphics();
        final ControlManager wasd_controller = new WASD_Controller();
        final ControlManager arrow_controller = new ArrowController();
        Display.addKeyListener(wasd_controller);
        Display.addKeyListener(arrow_controller);
        this.player1 = new Player(300.0, 300.0, Entity.createTextureMap("player1_up.png", "player1_down.png", "player1_left.png", "player1_right.png"), wasd_controller);
        this.player2 = new Player(400.0, 400.0, Entity.createTextureMap("player2_up.png", "player2_down.png", "player2_left.png", "player2_right.png"),  arrow_controller);
    }

    public synchronized void start() {
        if (this.running) {
            return;
        }
        this.running = true;
        (this.gameThread = new Thread(this)).start();
    }

    public synchronized void stop() {
        if (!this.running) {
            return;
        }
        this.running = false;
        try {
            this.gameThread.join();
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.cleanUp();
    }

    private void cleanUp() {
        Display.destroy();
    }

    private void update() {
        player1.update();
        player2.update();
    }

    private void render() {
        Display.clear();
        this.player1.render(this.graphics);
        this.player2.render(this.graphics);
        Display.swapBuffers();
    }

    @Override
    public void run() {
        int fps = 0;
        int upd = 0;
        int updl = 0;
        long count = 0L;
        float delta = 0.0f;
        long lastTime = Time.get();
        while (this.running) {
            final long now = Time.get();
            final long elapsedTime = now - lastTime;
            lastTime = now;
            count += elapsedTime;
            boolean render = false;
            delta += elapsedTime / Settings.UPDATE_INTERVAL;
            while (delta > 1.0f) {
                this.update();
                ++upd;
                --delta;
                if (render) {
                    ++updl;
                }
                else {
                    render = true;
                }
            }
            if (render) {
                this.render();
                ++fps;
            }
            else {
                try {
                    Thread.sleep(1L);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (count >= Time.SECOND) {
                Display.setTitle(Settings.TITLE + " || Fps: " + fps + " | Upd: " + upd + " | Updl: " + updl);
                upd = 0;
                fps = 0;
                updl = 0;
                count = 0L;
            }
        }
    }
}