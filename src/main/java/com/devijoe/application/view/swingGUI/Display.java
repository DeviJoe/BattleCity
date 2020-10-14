package com.devijoe.application.view.swingGUI;

import com.devijoe.application.service.game_controller.ControlManager;
import java.util.Arrays;
import java.awt.RenderingHints;
import java.awt.Graphics2D;
import java.awt.image.DataBufferInt;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Canvas;
import javax.swing.JFrame;

/**
 * Утилита для быстрой и удобной работы с формой
 */
public class Display {
    /** Проверка на создание окна */
    private static boolean created;
    /** Само окно */
    private static JFrame window;
    /** Слой с игрой */
    private static Canvas content;

    private static BufferedImage buffer;
    private static int[] bufferData;
    private static Graphics bufferGraphics;
    private static int clearColor;
    private static BufferStrategy bufferStrategy;

    /**
     * Метод создания окна
     * @param width - ширина
     * @param height - высота
     * @param title - заголовок
     * @param _clearColor
     * @param numBuffers
     */
    public static void create(final int width, final int height, final String title, final int _clearColor, final int numBuffers) {
        if (Display.created) {
            return;
        }
        (Display.window = new JFrame(title)).setDefaultCloseOperation(3);
        Display.content = new Canvas();
        final Dimension size = new Dimension(width, height);
        Display.content.setPreferredSize(size);
        Display.window.setResizable(false);
        Display.window.getContentPane().add(Display.content);
        Display.window.pack();
        Display.window.setLocationRelativeTo(null);
        Display.window.setVisible(true);
        Display.buffer = new BufferedImage(width, height, 2);
        Display.bufferData = ((DataBufferInt)Display.buffer.getRaster().getDataBuffer()).getData();
        Display.bufferGraphics = Display.buffer.getGraphics();
        ((Graphics2D)Display.bufferGraphics).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Display.clearColor = _clearColor;
        Display.content.createBufferStrategy(numBuffers);
        Display.bufferStrategy = Display.content.getBufferStrategy();
        Display.created = true;
    }

    /**
     * Очистка окна
     */
    public static void clear() {
        Arrays.fill(Display.bufferData, Display.clearColor);
    }


    public static void swapBuffers() {
        final Graphics g = Display.bufferStrategy.getDrawGraphics();
        g.drawImage(Display.buffer, 0, 0, null);
        Display.bufferStrategy.show();
    }

    public static Graphics2D getGraphics() {
        return (Graphics2D)Display.bufferGraphics;
    }

    /**
     * Разрушение окна
     */
    public static void destroy() {
        if (!Display.created) {
            return;
        }
        Display.window.dispose();
    }

    /** Установка нового заголовка */
    public static void setTitle(final String title) {
        Display.window.setTitle(title);
    }

    /**
     * Добавляет новый метод ввода
     * @param manager петод управления устройством
     */
    public static void addKeyListener(final ControlManager manager) {
        Display.window.addKeyListener(manager);
    }

    static {
        Display.created = false;
    }
}
