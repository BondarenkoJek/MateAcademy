package ua.bondarenkojek.lessons.pattern.factorymethod;

public class ProxyPatternExapmle implements PatternExample {

    @Override
    public Pattern makePattern() {
        return new ProxyPattern();
    }
}
