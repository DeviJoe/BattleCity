package devijoe.utils;

/**
 * Класс-утилита для определния времени, прошедшего с запуска игры
 */
public class Time
{
    /** Секунда в наносекундах */
    public static final long SECOND = 1000000000L;

    /**
     * Возвращает время с момента запуска игры
     * @return время в милисикундах
     */
    public static long get() {
        return System.nanoTime();
    }
}
