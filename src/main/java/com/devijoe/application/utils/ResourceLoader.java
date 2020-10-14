package com.devijoe.application.utils;

import lombok.SneakyThrows;

import java.io.IOException;
import javax.imageio.ImageIO;
import java.io.File;
import java.awt.image.BufferedImage;

/**
 * Класс-утилита для загрузки и обработки "сырого" изображения в читаемый игрой формат {@code BufferedImage}
 */
public class ResourceLoader
{


    /**
     * Метод осуществляет загрузку изображения
     * @param fileName путь до файла
     * @return {@code BufferedImage} изображение
     */
    @SneakyThrows
    public static BufferedImage loadImage(final String fileName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
