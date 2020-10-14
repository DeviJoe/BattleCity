package com.devijoe.application.service.game_controller;

public interface IUpdate {

    /**
     * Вызывает метод, обновляющий параметры объекта с каждым кадром
     * (Аналогичен подобному методу из Unity, только привязан к FPS)
     */
    void update();
}
