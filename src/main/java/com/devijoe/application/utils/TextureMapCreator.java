package com.devijoe.application.utils;

import com.devijoe.application.model.entity_description.Direction;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

public class TextureMapCreator {

    /**
     * Утилита автосборщика текстур в карту для объектов, имеющих направление
     * @param fileName_UP - текстура, смотрящая вверх (имя файла)
     * @param fileName_DOWN - текстура, смотрящая вниз (имя файла)
     * @param fileName_LEFT - текстура, смотрящая влево (имя файла)
     * @param fileName_RIGHT - текстура, смотрящая вправо (имя файла)
     * @return карта вида {@code Map<Direction, BufferedImage>}
     */
    public static Map<Direction, BufferedImage> createTextureMap(final String fileName_UP, final String fileName_DOWN, final String fileName_LEFT, final String fileName_RIGHT) {
        Map<Direction, BufferedImage> map = new HashMap<>();
        map.put(Direction.NORTH, ResourceLoader.loadImage(fileName_UP));
        map.put(Direction.SOUTH, ResourceLoader.loadImage(fileName_DOWN));
        map.put(Direction.EAST, ResourceLoader.loadImage(fileName_LEFT));
        map.put(Direction.WEST, ResourceLoader.loadImage(fileName_RIGHT));
        return map;
    }

    /**
     * Утилита автосборки текстур в карту для объектов без направления
     * @param fileName - имя файла с текстурой
     * @return карта вида {@code Map<Direction, BufferedImage>}
     */
    public static Map<Direction, BufferedImage> createTextureMap(final String fileName) {
        Map<Direction, BufferedImage> map = new HashMap<>();
        map.put(Direction.NORTH, ResourceLoader.loadImage(fileName));
        map.put(Direction.SOUTH, ResourceLoader.loadImage(fileName));
        map.put(Direction.EAST, ResourceLoader.loadImage(fileName));
        map.put(Direction.WEST, ResourceLoader.loadImage(fileName));
        return map;
    }

}
