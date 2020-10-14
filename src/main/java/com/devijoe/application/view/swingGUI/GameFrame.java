package com.devijoe.application.view.swingGUI;


import com.devijoe.application.Settings;
import com.devijoe.application.model.Entity;
import com.devijoe.application.model.Player;
import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.service.PlayerService;
import com.devijoe.application.service.game_controller.ArrowController;
import com.devijoe.application.service.game_controller.ControlManager;
import com.devijoe.application.service.game_controller.WASD_Controller;
import com.devijoe.application.utils.TextureMapCreator;
import com.devijoe.application.utils.Time;
import java.awt.Graphics2D;

public class GameFrame implements Runnable
{
    private boolean running;
    private Thread gameThread;
    private Graphics2D graphics;
    private PlayerService player1;
    private PlayerService player2;

    public GameFrame() {
        this.running = false;
        Display.create(800, 600, Settings.TITLE, -16777216, 3);
        this.graphics = Display.getGraphics();
        final ControlManager wasd_controller = new WASD_Controller();
        final ControlManager arrow_controller = new ArrowController();
        Display.addKeyListener(wasd_controller);
        Display.addKeyListener(arrow_controller);
        player1 = new PlayerService(
                300,
                300,
                5,
                3,
                Direction.NORTH,
                wasd_controller
        );

        player2 = new PlayerService(
                400,
                400,
                5,
                3,
                Direction.NORTH,
                arrow_controller
        );
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