package com.devijoe.application.view.spriteModule;


import com.devijoe.application.Settings;
import lombok.Data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;


public enum TextureType {

    YELLOW_STANDARD_TANK(Arrays.asList(
            new Container(0 * Settings.TANK_TEXTURE_SIZE, 0 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(2 * Settings.TANK_TEXTURE_SIZE, 2 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(4 * Settings.TANK_TEXTURE_SIZE, 4 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(6 * Settings.TANK_TEXTURE_SIZE, 6 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE)
    )),

    GREEN_STANDARD_TANK(Arrays.asList(
            new Container(0 * Settings.TANK_TEXTURE_SIZE, 0 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(2 * Settings.TANK_TEXTURE_SIZE, 2 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(4 * Settings.TANK_TEXTURE_SIZE, 4 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE),
            new Container(6 * Settings.TANK_TEXTURE_SIZE, 6 * Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE, Settings.TANK_TEXTURE_SIZE)
            ));


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

    private List<Container> textureContext;

    TextureType(List<Container> textureContext) {
        this.textureContext = textureContext;
    }

    public List<Container> getTextureContext() {
        return textureContext;
    }
}
