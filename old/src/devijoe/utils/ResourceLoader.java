package devijoe.utils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Класс-утилита для загрузки и обработки "сырого" изображения в читаемый игрой формат {@code BufferedImage}
 */
public class ResourceLoader
{
    public static final String PATH = "resources/";

    /**
     * Метод осуществляет загрузку изображения
     * @param fileName путь до файла
     * @return {@code BufferedImage} изображение
     */
    public static BufferedImage loadImage(final String fileName) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(PATH + fileName));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
