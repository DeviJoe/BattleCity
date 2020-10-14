package devijoe;

/**
 * Класс для настройки параметров игры
 */
public class Settings {

    /** Системные параметры игры (НЕ ТРОГАТЬ!) */

    // Ширина окна
    public static final int WIDTH = 800;
    // Высота окна
    public static final int HEIGHT = 600;
    // Название игры в строке-титле
    public static final String TITLE = "Tanks";
    // Цвет фона
    public static final int CLEAR_COLOR = -16777216;
    //
    public static final int NUM_BUFFERS = 3;
    // Частота обновления кадров
    public static final float UPDATE_RATE = 60.0f;
    // Интервал обновления
    public static final float UPDATE_INTERVAL = 1.6666667E7f;
    // Время обновления
    public static final long IDLE_TIME = 1L;

    /** Параметры игры */

    //Скорость танка
    public static final int TANK_SPEED = 3;
    // Скорость полета пули
    public static final int BULLET_SPEED = 3;
    //
    public static final int TANK_HP = 1;

    public static final int TANK_LEVEL = 1;
}
