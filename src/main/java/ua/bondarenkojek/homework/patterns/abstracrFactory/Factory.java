package ua.bondarenkojek.homework.patterns.abstracrFactory;

public interface Factory<T> {
    T getObject(String name);
}
