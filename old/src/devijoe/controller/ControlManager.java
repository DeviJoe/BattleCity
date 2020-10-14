package devijoe.controller;

import java.awt.event.KeyListener;

/**
 * Класс декларирует основные методы управления танком
 */
public abstract class ControlManager implements KeyListener {

    /**
     * Проверка на нажатие клавиши "Вверх"
     * @return true - если нажато /false - если нет
     */
    public abstract boolean isUpPressed();

    /**
     * Проверка на нажатие клавиши "Вниз"
     * @return true - если нажато /false - если нет
     */
    public abstract boolean isDownPressed();

    /**
     * Проверка на нажатие клавиши "Влево"
     * @return true - если нажато /false - если нет
     */
    public abstract boolean isLeftPressed();

    /**
     * Проверка на нажатие клавиши "Вправо"
     * @return true - если нажато /false - если нет
     */
    public abstract boolean isRightPressed();

    /**
     * Проверка на нажатие клавиши "Огонь"
     * @return true - если нажато /false - если нет
     */
    public abstract boolean isFirePressed();
}