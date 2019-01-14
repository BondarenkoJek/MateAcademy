package ua.bondarenkojek.homework.patterns.abstracrFactory;

import ua.bondarenkojek.homework.patterns.abstracrFactory.factories.CarFactory;
import ua.bondarenkojek.homework.patterns.abstracrFactory.factories.MotorbikeFactory;

public class AbstractFactory {
    public static Factory gerCarFactory() {
        return new CarFactory();
    }

    public static Factory gerMotorbikeFactory() {
        return new MotorbikeFactory();
    }
}
