package ua.bondarenkojek.homework.jpa.model.device;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.Test;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "photometer")
public class Photometer extends Device {
    @Override
    public void doTest(Test test, Patient patient) {
        System.out.println("Doing blood test by photometer!");
        super.doTest(test, patient);
    }
}
