package ua.bondarenkojek.homework.jpa.model.device;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import javax.persistence.Entity;

@Entity(name = "ultrasonic_device")
public class UltrasonicDevice extends Device {
    @Override
    public void doTest(Test test, Patient patient) {
        System.out.println("Doing skin test by ultrasonic device!");
        super.doTest(test, patient);
    }
}
