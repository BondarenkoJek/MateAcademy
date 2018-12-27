package ua.bondarenkojek.lessons.pattern.factorymethod;

public class SingletonPatternExample implements PatternExample {

    @Override
    public Pattern makePattern() {
        return SingletonPattern.getInstance();
    }
}
