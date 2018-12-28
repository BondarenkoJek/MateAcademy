package ua.bondarenkojek.lessons.pattern.factorymethod;

public class BuilderPatternExample implements PatternExample {
    @Override
    public Pattern makePattern() {
        return BuilderPattern.builder().build();
    }
}
