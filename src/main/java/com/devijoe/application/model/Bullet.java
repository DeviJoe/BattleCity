package com.devijoe.application.model;

import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.model.entity_description.EntityType;
import lombok.EqualsAndHashCode;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;

@EqualsAndHashCode
public class Bullet extends Entity {
    /** Скорость полета */
    private final double speed;
    /** Направление полета */
    private final Direction direction;

    /**
     * @param x          - координата X нижнего левого угла объекта
     * @param y          - координата У нижнего левого угла объекта
     * @param entityType - тип объекта
     * @param texture    - карта с текстурами объекта
     * @param speed      - скорость полета пули
     * @param direction  - направление полета пули
     */
    public Bullet(double x, double y, EntityType entityType, HashMap<Direction, BufferedImage> texture, double speed, Direction direction) {
        super(x, y, entityType, texture);
        this.speed = speed;
        this.direction = direction;
    }

    public double getSpeed() {
        return speed;
    }

    public Direction getDirection() {
        return direction;
    }

}