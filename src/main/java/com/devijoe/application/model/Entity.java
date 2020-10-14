package com.devijoe.application.model;

import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.model.entity_description.EntityType;
import com.devijoe.application.model.entity_description.Key;
import com.devijoe.application.model.entity_description.Position;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Декларирует поведение любой сущности в игре
 */
@EqualsAndHashCode
public abstract class Entity {

    /** Структура хранит и расчитывает координаты объекта */
    @Getter @Setter
    private Position position;

    /** Ширина объекта (по текстуре) */
    @Getter
    private final double width;

    /** Высота объекта (по текстуре) */
    @Getter
    private final double height;

    /** Тип объекта */
    @Getter
    private final EntityType entityType;

    /** Карта, хранящая текстуры объекта в зависимости от их направления */
    @Getter
    private final Map<? extends Key, BufferedImage> texture;

    /** Текущая текстура */
    @Getter @Setter
    private BufferedImage currentTexture;

    /**
     *
     * @param x - координата X нижнего левого угла объекта
     * @param y - координата У нижнего левого угла объекта
     * @param entityType - тип объекта
     * @param texture - карта с текстурами объекта
     */
    public Entity(final double x, final double y, final EntityType entityType, final Map<? extends Key, BufferedImage> texture) {
        this.width = texture.get(Direction.NORTH).getWidth();
        this.height = texture.get(Direction.NORTH).getHeight();
        this.entityType = entityType;
        this.texture = texture;
        this.currentTexture = texture.get(Direction.NORTH);
        this.position = new Position(x, y, width, height);
    }


}