package ua.bondarenkojek.homework.singleton;

/**
 * Created by jek on 12/8/18.
 */
public class Singleton {
    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton newInstanse() {
        if (instance == null) {
            synchronized (Singleton.class) {
                instance = new Singleton();
            }
        }
        return instance;
    }
}
