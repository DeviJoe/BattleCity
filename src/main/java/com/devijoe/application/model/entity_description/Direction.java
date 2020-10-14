package com.devijoe.application.model.entity_description;

/**
 * Служит для перечисления направлений "взгляда" объекта
 */
public enum Direction implements Key{
    /** Запад */
    EAST(270),
    /** Север */
    NORTH(0),
    /** Юг */
    SOUTH(180),
    /** Восток */
    WEST(90);

    /** Угол взгляда */
    private double angle;

    private Direction(final double angle) {
        this.angle = angle;
    }
}
