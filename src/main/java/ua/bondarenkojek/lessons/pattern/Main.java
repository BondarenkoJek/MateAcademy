package ua.bondarenkojek.lessons.pattern;

import ua.bondarenkojek.lessons.pattern.factorymethod.BuilderPatternExample;
import ua.bondarenkojek.lessons.pattern.factorymethod.Pattern;
import ua.bondarenkojek.lessons.pattern.factorymethod.PatternExample;
import ua.bondarenkojek.lessons.pattern.factorymethod.ProxyPatternExapmle;
import ua.bondarenkojek.lessons.pattern.factorymethod.SingletonPatternExample;

public class Main {
    public static void main(String[] args) {
        PatternExample builderPatternExample = new BuilderPatternExample();
        PatternExample singletonPatternExample = new SingletonPatternExample();
        PatternExample proxyPatternExample = new ProxyPatternExapmle();

        Pattern builder = builderPatternExample.makePattern();
        Pattern singleton = singletonPatternExample.makePattern();
        Pattern proxy = proxyPatternExample.makePattern();

        System.out.println("I'm " + builder.getPatterName());
        System.out.println("I'm " + singleton.getPatterName());
        System.out.println("I'm " + proxy.getPatterName());
    }
}
