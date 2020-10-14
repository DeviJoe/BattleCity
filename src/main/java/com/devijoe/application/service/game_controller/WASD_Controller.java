package com.devijoe.application.service.game_controller;

import java.awt.event.KeyEvent;

/**
 * Реализовывает управление танком для JPanel на классической WASD раскладке
 */
public class WASD_Controller extends ControlManager
{
    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean isFire;

    public WASD_Controller() {
        this.isLeft = false;
        this.isRight = false;
        this.isUp = false;
        this.isDown = false;
        this.isFire = false;
    }

    @Override
    public boolean isUpPressed() {
        return this.isUp;
    }

    @Override
    public boolean isDownPressed() {
        return this.isDown;
    }

    @Override
    public boolean isLeftPressed() {
        return this.isLeft;
    }

    @Override
    public boolean isRightPressed() {
        return this.isRight;
    }

    @Override
    public boolean isFirePressed() {
        return this.isFire;
    }

    @Override
    public void keyTyped(final KeyEvent e) {
    }

    @Override
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            this.isLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.isRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.isUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.isDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.isFire = true;
        }
    }

    @Override
    public void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_A) {
            this.isLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_D) {
            this.isRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            this.isUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_S) {
            this.isDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            this.isFire = false;
        }
    }
}
