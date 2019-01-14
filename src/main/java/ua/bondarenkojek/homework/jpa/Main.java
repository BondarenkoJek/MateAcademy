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
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        PatientService ps = ServiceFactory.getPatientService();
        TestService ts = ServiceFactory.getTestService();
        DeviceService ds = ServiceFactory.getDeviseService();

        Patient patient1 = Patient
                .builder()
                .name("Jek")
                .dateOfBirth(LocalDate.of(1992, 1, 7))
                .tests(new ArrayList<>())
                .build();

        Test test1 = Test.getTest(Test.TestType.BLOOD);
        Device photometer = new Photometer();
        photometer.addAccessory(new PhotometerAccessory());
        ds.addDevice(photometer);
        photometer.doTest(test1, patient1);
        System.out.println(test1.getResult());

        Patient patient2 = Patient
                .builder()
                .name("Vasia")
                .dateOfBirth(LocalDate.of(1997, 11, 5))
                .tests(new ArrayList<>())
                .build();

        Test test2 = Test.getTest(Test.TestType.SKIN);
        Device ultrasonic = new UltrasonicDevice();
        ultrasonic.addAccessory(new UltrasonicAccessory());
        ds.addDevice(ultrasonic);
        ultrasonic.doTest(test2, patient2);
        System.out.println(test2.getResult());

        ps.addPatient(patient1);
        ps.addPatient(patient2);

        System.out.println(ts.getAllTests());
        System.out.println(ts.getPatientsWithGlucoseHigherThan(2.0));
    }
}
