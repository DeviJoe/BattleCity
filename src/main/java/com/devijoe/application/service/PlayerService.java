package com.devijoe.application.service;

import com.devijoe.application.Settings;
import com.devijoe.application.model.Entity;
import com.devijoe.application.model.Player;
import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.service.game_controller.ControlManager;
import com.devijoe.application.service.game_controller.IUpdate;
import com.devijoe.application.view.IRender;
import com.devijoe.application.view.spriteModule.TextureType;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Map;

/**
 * Затащить текстуру
 * Настроить объект
 *
 */
public class PlayerService implements IRender, IUpdate {

    Entity player;
    TextureService textureService = new TextureService();
    ControlManager manager;

    // todo Настройку player поизводить через фабрику
    public PlayerService(double x, double y, double speed, int hp, Direction direction, ControlManager manager) {
        this.player = new Player(
                x,
                y,
                textureService.generateTextureMapForModel(TextureType.GREEN_STANDARD_TANK),
                3,
                3,
                Direction.NORTH,
                manager);
        this.manager = manager;
    }

    @Override
    public void update() {

        double newX = player.getPosition().getDownLeft().getX();
        double newY = player.getPosition().getDownLeft().getY();

        if (player instanceof Player) {

            if (((Player) player).getControl().isUpPressed()) {
                newY -= ((Player) player).getSpeed();
                player.setCurrentTexture(player.getTexture().get(Direction.NORTH));
                ((Player) player).setDirection(Direction.NORTH);
            } else if (((Player) player).getControl().isDownPressed()) {
                newY += ((Player) player).getSpeed();
                ((Player) player).setDirection(Direction.SOUTH);
                player.setCurrentTexture(player.getTexture().get(Direction.SOUTH));
            } else if (((Player) player).getControl().isLeftPressed()) {
                newX -= ((Player) player).getSpeed();
                ((Player) player).setDirection(Direction.EAST);
                player.setCurrentTexture(player.getTexture().get(Direction.EAST));
            } else if (((Player) player).getControl().isRightPressed()) {
                newX += ((Player) player).getSpeed();
                ((Player) player).setDirection(Direction.WEST);
                player.setCurrentTexture(player.getTexture().get(Direction.WEST));
            }
            if (newX < 0.0) {
                newX = 0.0;
            }
            if (newY < 0.0) {
                newY = 0.0;
            }
            player.getPosition().update(newX, newY);
        }
    }

    // todo вытащить за пределы сервиса во view
    @Override
    public void render(final Graphics2D g) {
        g.drawImage(
                player.getCurrentTexture(),
                (int) player.getPosition().getDownLeft().getX(),
                (int)player.getPosition().getDownLeft().getY(),
                player.getCurrentTexture().getWidth() * Settings.TEXTURE_SCALE,
                player.getCurrentTexture().getHeight() * 2,
                null
        );
    }
}
