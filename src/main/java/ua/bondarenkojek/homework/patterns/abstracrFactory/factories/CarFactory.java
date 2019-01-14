package ua.bondarenkojek.homework.patterns.abstracrFactory.factories;

import ua.bondarenkojek.homework.patterns.abstracrFactory.cars.Car;
import ua.bondarenkojek.homework.patterns.abstracrFactory.Factory;
import ua.bondarenkojek.homework.patterns.abstracrFactory.cars.Audi;
import ua.bondarenkojek.homework.patterns.abstracrFactory.cars.Volvo;

public class CarFactory implements Factory<Car> {
    @Override
    public Car getObject(String name) {
        switch (name) {
            case "Audi": return new Audi();
            case "Volvo": return new Volvo();
        }
        return null;
    }
}
