package devijoe.model;



import devijoe.controller.ControlManager;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Класс реализует поведение танка, управляемого игроком
 */
public class Player extends Tank {

    /** Система управления танком */
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

    @Override
    public void update() {
        double newX = this.position.DownLeft.x;
        double newY = this.position.DownLeft.y;
        if (this.control.isUpPressed()) {
            newY -= this.getSpeed();
            this.setCurrentTexture(this.getTexture().get(Direction.NORTH));
            this.setDirection(Direction.NORTH);
        }
        else if (this.control.isDownPressed()) {
            newY += this.getSpeed();
            this.setDirection(Direction.SOUTH);
            this.setCurrentTexture(this.getTexture().get(Direction.SOUTH));
        }
        else if (this.control.isLeftPressed()) {
            newX -= this.getSpeed();
            this.setDirection(Direction.EAST);
            this.setCurrentTexture(this.getTexture().get(Direction.EAST));
        }
        else if (this.control.isRightPressed()) {
            newX += this.getSpeed();
            this.setDirection(Direction.WEST);
            this.setCurrentTexture(this.getTexture().get(Direction.WEST));
        }
        if (newX < 0.0) {
            newX = 0.0;
        }
        if (newY < 0.0) {
            newY = 0.0;
        }
        this.position.update(newX, newY);
    }

    @Override
    public void render(final Graphics2D g) {
        g.drawImage(this.getCurrentTexture(), (int)this.position.DownLeft.x, (int)this.position.DownLeft.y, this.getCurrentTexture().getWidth() * 2, this.getCurrentTexture().getHeight() * 2, null);
    }

}