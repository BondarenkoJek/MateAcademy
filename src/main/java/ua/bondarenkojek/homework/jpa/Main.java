package ua.bondarenkojek.homework.jpa;

import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.accessory.PhotometerAccessory;
import ua.bondarenkojek.homework.jpa.model.accessory.UltrasonicAccessory;
import ua.bondarenkojek.homework.jpa.model.device.Device;
import ua.bondarenkojek.homework.jpa.model.device.Photometer;
import ua.bondarenkojek.homework.jpa.model.device.UltrasonicDevice;
import ua.bondarenkojek.homework.jpa.model.test.Test;
import ua.bondarenkojek.homework.jpa.service.DeviceService;
import ua.bondarenkojek.homework.jpa.service.PatientService;
import ua.bondarenkojek.homework.jpa.service.TestService;
import ua.bondarenkojek.homework.jpa.service.factory.ServiceFactory;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        PatientService ps = ServiceFactory.getPatientService();
        TestService ts = ServiceFactory.getTestService();
        DeviceService ds = ServiceFactory.getDeviseService();

        Patient patient1 = Patient
                .builder()
                .name("Jek")
                .dateOfBirth(LocalDate.of(1992, 1, 7))
                .build();

        Test test1 = Test.getTest(Test.TestType.BLOOD);
        Device photometer = new Photometer();
        photometer.addAccessory(new PhotometerAccessory());
        photometer.addTest(test1);
        ds.doTest(test1, patient1);
        ds.addDevice(photometer);

        System.out.println(test1.getResult());

        Patient patient2 = Patient
                .builder()
                .name("Vasia")
                .dateOfBirth(LocalDate.of(1997, 11, 5))
                .build();

        Test test2 = Test.getTest(Test.TestType.SKIN);
        Device ultrasonic = new UltrasonicDevice();
        ultrasonic.addAccessory(new UltrasonicAccessory());
        ultrasonic.addTest(test2);
        ds.addDevice(ultrasonic);
        ds.doTest(test2, patient2);
        System.out.println(test2.getResult());

        ps.addPatient(patient1);
        ps.addPatient(patient2);

        System.out.println(ts.getAllTests());
        System.out.println(ts.getPatientsWithGlucoseHigherThan(2.0));
    }
}
