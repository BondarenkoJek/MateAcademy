package ua.bondarenkojek.homework.patterns.abstracrFactory.factories;

import ua.bondarenkojek.homework.patterns.abstracrFactory.Factory;
import ua.bondarenkojek.homework.patterns.abstracrFactory.motobikes.Jawa;
import ua.bondarenkojek.homework.patterns.abstracrFactory.motobikes.Motorbike;
import ua.bondarenkojek.homework.patterns.abstracrFactory.motobikes.Suzuki;

public class MotorbikeFactory implements Factory<Motorbike> {
    @Override
    public Motorbike getObject(String name) {
        switch (name) {
            case "Suzuki":
                return new Suzuki();
            case "Jawa":
                return new Jawa();
        }
        return null;
    }
}
