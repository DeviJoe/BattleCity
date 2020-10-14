package com.devijoe.application.model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Map;

import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.model.entity_description.EntityType;
import com.devijoe.application.service.game_controller.ControlManager;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Класс реализует поведение танка, управляемого игроком
 */
@EqualsAndHashCode
public class Player extends Tank {

    /** Система управления танком */
    @Getter
    private final ControlManager control;

    /**
     * @param x          - координата X нижнего левого угла объекта
     * @param y          - координата У нижнего левого угла объекта
     * @param texture    - карта с текстурами объекта
     * @param speed      - скорость танка
     * @param hp         - уровень здоровья танка
     * @param direction  - направление взгляда танка
     * @param control    - система управления танком
     */

    public Player(double x, double y, Map<Direction, BufferedImage> texture, double speed, int hp, Direction direction, ControlManager control) {
        super(x, y, EntityType.PLAYER, texture, speed, hp, direction);
        this.control = control;
    }

    public Player(double x, double y, Map<Direction, BufferedImage> texture, ControlManager control) {
        super(x, y, EntityType.PLAYER, texture);
        this.control = control;
    }

}