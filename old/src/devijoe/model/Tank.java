package devijoe.model;



import devijoe.Settings;

import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Абстрактный класс, декларирующий поведение всех танков в игре
 */
public abstract class Tank extends Entity {

    /** Скорость танка */
    private double speed;
    /** Уровень здоровья танка */
    private int hp;
    /** Направление движения танка */
    private Direction direction;
    /** Уровень прогрессии танка */
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

    public Direction getDirection() {
        return this.direction;
    }

    public void setDirection(final Direction direction) {
        this.direction = direction;
    }

    public void setSpeed(final double speed) {
        this.speed = speed;
    }

    public void setHp(final int hp) {
        this.hp = hp;
    }

    public double getSpeed() {
        return this.speed;
    }

    public int getHp() {
        return this.hp;
    }



}