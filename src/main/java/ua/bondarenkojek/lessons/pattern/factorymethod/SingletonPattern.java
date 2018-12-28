package ua.bondarenkojek.lessons.pattern.factorymethod;

public final class SingletonPattern implements Pattern {
    private static volatile SingletonPattern instance;
    private SingletonPattern() {}

    public static SingletonPattern getInstance() {
        if (instance == null) {
            synchronized (SingletonPattern.class) {
                instance = new SingletonPattern();
                return instance;
            }
        }
        return instance;
    }

    @Override
    public String getPatterName() {
        return "Singleton";
    }
}
