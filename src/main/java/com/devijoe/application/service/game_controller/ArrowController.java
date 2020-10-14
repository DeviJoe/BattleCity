package com.devijoe.application.service.game_controller;

import java.awt.event.KeyEvent;

/**
 * Класс реализовывает управление для JPanel на "стрелках"
 */
public class ArrowController extends ControlManager {

    private boolean isLeft;
    private boolean isRight;
    private boolean isUp;
    private boolean isDown;
    private boolean isFire;
    
    public ArrowController() {
        this.isLeft = false;
        this.isRight = false;
        this.isUp = false;
        this.isDown = false;
        this.isFire = false;
    }
    
    public boolean isUpPressed() {
        return this.isUp;
    }
    
    public boolean isDownPressed() {
        return this.isDown;
    }
    
    public boolean isLeftPressed() {
        return this.isLeft;
    }
    
    public boolean isRightPressed() {
        return this.isRight;
    }
    
    public boolean isFirePressed() {
        return this.isFire;
    }
    
    public void keyTyped(final KeyEvent e) {
    }
    
    public void keyPressed(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.isRight = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.isUp = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.isDown = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.isFire = true;
        }
    }
    
    public void keyReleased(final KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            this.isLeft = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            this.isRight = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            this.isUp = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            this.isDown = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            this.isFire = false;
        }
    }
}
