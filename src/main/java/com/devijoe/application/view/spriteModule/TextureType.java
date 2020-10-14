package com.devijoe.application.view.spriteModule;


import com.devijoe.application.Settings;
import com.devijoe.application.model.entity_description.Direction;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;


public enum TextureType {

    YELLOW_STANDARD_TANK((LinkedList) Arrays.asList(
            new Container(0 * Settings.TANK_TEXTURE_SIZE, 0 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(2 * Settings.TANK_TEXTURE_SIZE, 2 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(4 * Settings.TANK_TEXTURE_SIZE, 4 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(6 * Settings.TANK_TEXTURE_SIZE, 6 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE)
    ),
            Direction.values()),

    GREEN_STANDARD_TANK((LinkedList) Arrays.asList(
            new Container(0 * Settings.TANK_TEXTURE_SIZE, 0 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(2 * Settings.TANK_TEXTURE_SIZE, 2 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(4 * Settings.TANK_TEXTURE_SIZE, 4 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(6 * Settings.TANK_TEXTURE_SIZE, 6 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE)
            ),
            Direction.values());


    @Data
    public static class Container {
        private int x;
        private int y;
        private int w;
        private int h;

        public Container(int x, int y, int w, int h) {
            this.x = x;
            this.y = y;
            this.w = w;
            this.h = h;
        }
    }

    private LinkedList<Container> textureContext;

    Enum[] anEnum;

    TextureType(LinkedList<Container> textureContext, Enum[] anEnum) {
        this.textureContext = textureContext;
        this.anEnum = anEnum;
    }

    public LinkedList<Container> getTextureContext() {
        return textureContext;
    }

    public Enum[] getAnEnum() {
        return anEnum;
    }
}
