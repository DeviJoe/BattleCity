package com.devijoe.application.service;

import com.devijoe.application.model.entity_description.Direction;
import com.devijoe.application.model.entity_description.Key;
import com.devijoe.application.view.spriteModule.TextureAtlas;
import com.devijoe.application.view.spriteModule.TextureType;

import java.awt.image.BufferedImage;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Генерирует мапу с текстурами по соответствующему запросу
 */
public class TextureService {

    private TextureAtlas atlas = new TextureAtlas("src/main/resources/texture/texture_atlas.png");

    public Map<Enum, BufferedImage> generateTextureMapForModel(TextureType type) {

        Map map = new HashMap();

        List<Enum> enums = new LinkedList<>();

        for (Enum anEnum : type.getAnEnum()) {
            enums.add(anEnum);
        }

        int i = 0;
        for (TextureType.Container container : type.getTextureContext()) {
            map.put(enums.get(i), atlas.cut(container.getX(), container.getY(), container.getW(), container.getH()));
            i++;
        }

        return map;



    }
}
