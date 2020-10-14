package devijoe.model;



import devijoe.controller.IUpdate;
import devijoe.utils.ResourceLoader;
import devijoe.view.IRender;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

/**
 * Декларирует поведение любой сущности в игре
 */
public abstract class Entity implements IRender, IUpdate {

    /**
     * Служт для описания точки в координатной плоскости
     */
    static class Point {
        /** Координата Х */
        double x;
        /** Координата У */
        double y;

        public Point(final double x, final double y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * Класс служит для храния пространственных координат прямоугольного объекта по его вершинам
     */
    static class Position {

        /** Идет перечисление точек - вершин прямоугольника */
        Point DownLeft;
        Point UpLeft;
        Point UpRight;
        Point DownRight;

        /** Ширина модели */
        private double width;
        /** Высота модели */
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

    /**
     * Служит для перечисления направлений "взгляда" объекта
     */
    enum Direction {
        /** Запад */
        EAST(270),
        /** Север */
        NORTH(0),
        /** Юг */
        SOUTH(80),
        /** Восток */
        WEST(90);

        /** Угол взгляда */
        private double angle;

        private Direction(final double angle) {
            this.angle = angle;
        }
    }

    /**
     * Ведет перечисление видов игровых сущностей
     */
    enum EntityType {
        /** Игрок */
        PLAYER,
        /** Блок */
        BLOCK,
        /** Поднимаемые бонусы */
        BONUS,
        /** База */
        BASE,
        /** Вражеские танки */
        ENEMY
    }

    /** Структура хранит и расчитывает координаты объекта */
    Position position;
    /** Ширина объекта (по текстуре) */
    private final double width;
    /** Высота объекта (по текстуре) */
    private final double height;
    /** Тип объекта */
    private final EntityType entityType;
    /** Карта, хранящая текстуры объекта в зависимости от их направления */
    private final Map<Direction, BufferedImage> texture;
    /** Текущая текстура */
    private BufferedImage currentTexture;

    /**
     *
     * @param x - координата X нижнего левого угла объекта
     * @param y - координата У нижнего левого угла объекта
     * @param entityType - тип объекта
     * @param texture - карта с текстурами объекта
     */
    public Entity(final double x, final double y, final EntityType entityType, final Map<Direction, BufferedImage> texture) {
        this.width = texture.get(Direction.NORTH).getWidth();
        this.height = texture.get(Direction.NORTH).getHeight();
        this.entityType = entityType;
        this.texture = texture;
        this.currentTexture = texture.get(Direction.NORTH);
        this.position = new Position(x, y, width, height);
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCurrentTexture(BufferedImage currentTexture) {
        this.currentTexture = currentTexture;
    }

    public Position getPosition() {
        return position;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    public Map<Direction, BufferedImage> getTexture() {
        return texture;
    }

    public BufferedImage getCurrentTexture() {
        return currentTexture;
    }

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