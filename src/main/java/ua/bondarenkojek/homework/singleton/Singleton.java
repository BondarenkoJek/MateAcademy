package ua.bondarenkojek.homework.singleton;

public class Singleton {
    private static volatile Singleton instance;

    private Singleton() {
    }

    public static Singleton newInstanse() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
