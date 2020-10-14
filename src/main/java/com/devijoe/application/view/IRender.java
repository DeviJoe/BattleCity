package com.devijoe.application.view;

import java.awt.*;

/**
 * Служит для декларации основных методов отображения объекта
 */
public interface IRender {

    /**
     * Отрисовывает объект, вызывается каждый кадр (привязан к FPS)
     * @param g - модуль графики
     */
    void render(final Graphics2D g);
}
