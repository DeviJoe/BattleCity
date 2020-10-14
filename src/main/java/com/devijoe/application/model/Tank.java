package com.devijoe.application.model;

import com.devijoe.application.Settings;
import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.model.entity_description.EntityType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Абстрактный класс, декларирующий поведение всех танков в игре
 */
@EqualsAndHashCode
public abstract class Tank extends Entity {

    /** Скорость танка */
    @Getter @Setter
    private double speed;

    /** Уровень здоровья танка */
    @Getter @Setter
    private int hp;

    /** Направление движения танка */
    @Getter @Setter
    private Direction direction;

    /** Уровень прогрессии танка */
    @Getter @Setter
    private int level;

    /**
     * @param x          - координата X нижнего левого угла объекта
     * @param y          - координата У нижнего левого угла объекта
     * @param entityType - тип объекта
     * @param texture    - карта с текстурами объекта
     * @param speed      - скорость танка
     * @param hp         - уровень здоровья танка
     * @param direction  - направление взгляда танка
     */
    public Tank(double x, double y, EntityType entityType, Map<Direction, BufferedImage> texture, double speed, int hp, Direction direction) {
        super(x, y, entityType, texture);
        this.speed = speed;
        this.direction = direction;
        this.hp = hp;
        this.level = 1;
    }

    public Tank(double x, double y, EntityType entityType, Map<Direction, BufferedImage> texture) {
        super(x, y, entityType, texture);
        speed = Settings.TANK_SPEED;
        direction = Direction.NORTH;
        hp = Settings.TANK_HP;
        level = Settings.TANK_LEVEL;
    }




}