package com.devijoe.application.model.entity_description;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * Служт для описания точки в координатной плоскости
 */

@Data
public class Point {

    /** Координата Х */
    @Getter @Setter
    private double x;

    /** Координата У */
    @Getter @Setter
    private double y;

    public Point(final double x, final double y) {
        this.x = x;
        this.y = y;
    }
}
