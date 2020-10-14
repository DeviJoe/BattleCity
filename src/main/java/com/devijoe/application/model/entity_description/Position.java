package com.devijoe.application.model.entity_description;

import lombok.Getter;

/**
 * Класс служит для храния пространственных координат прямоугольного объекта по его вершинам
 */
public class Position {

    /** Идет перечисление точек - вершин прямоугольника */
    @Getter
    private Point DownLeft;
    @Getter
    private Point UpLeft;
    @Getter
    private Point UpRight;
    @Getter
    private Point DownRight;

    /** Ширина модели */
    @Getter
    private double width;

    /** Высота модели */
    @Getter
    private double height;

    public Position(final double x, final double y, final double width, final double height) {
        this.DownLeft = new Point(x, y);
        this.UpLeft = new Point(x, y + height);
        this.UpRight = new Point(x + width, y + height);
        this.DownRight = new Point(x + width, y);
        this.width = width;
        this.height = height;
    }

    /**
     * Метод обновляет значения всех координат
     * @param x
     * @param y
     */
    public void update(final double x, final double y) {
        this.DownLeft.x = x;
        this.DownLeft.y = y;
        this.UpLeft.x = x;
        this.UpLeft.y = y + height;
        this.UpRight.x = x + width;
        this.UpRight.y = y + height;
        this.DownRight.x = x + width;
        this.DownRight.y = y;
    }
}
