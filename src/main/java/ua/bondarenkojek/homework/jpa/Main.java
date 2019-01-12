package ua.bondarenkojek.homework.jpa;

import ua.bondarenkojek.homework.jpa.dao.DeviceDao;
import ua.bondarenkojek.homework.jpa.dao.TestDao;
import ua.bondarenkojek.homework.jpa.dao.impl.DeviceDaoImpl;
import ua.bondarenkojek.homework.jpa.dao.impl.PatientDaoImpl;
import ua.bondarenkojek.homework.jpa.dao.impl.TestDaoImpl;
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
import ua.bondarenkojek.homework.jpa.service.impl.DeviceServiceImpl;
import ua.bondarenkojek.homework.jpa.service.impl.PatientServiceImpl;
import ua.bondarenkojek.homework.jpa.service.impl.TestServiceImpl;
import ua.bondarenkojek.homework.jpa.util.HibernateUtil;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EntityManager em = HibernateUtil.getEntityManager();
        PatientService ps = new PatientServiceImpl(new PatientDaoImpl(em));
        TestService ts = new TestServiceImpl(new TestDaoImpl(em));
        DeviceService ds = new DeviceServiceImpl(new DeviceDaoImpl(em));

//        Patient patient1 = Patient
//                .builder()
//                .name("Jek")
//                .dateOfBirth(LocalDate.of(1992, 1, 7))
//                .tests(new ArrayList<>())
//                .build();
//
//        Test test1 = Test.getTest(Test.TestType.BLOOD);
//        Device photometer = new Photometer();
//        photometer.addAccessory(new PhotometerAccessory());
//        ds.createEntity(photometer);
//        photometer.doTest(test1, patient1);
//        System.out.println(test1.getResult());
//
//        Patient patient2 = Patient
//                .builder()
//                .name("Vasia")
//                .dateOfBirth(LocalDate.of(1997, 11, 5))
//                .tests(new ArrayList<>())
//                .build();
//
//        Test test2 = Test.getTest(Test.TestType.SKIN);
//        Device ultrasonic = new UltrasonicDevice();
//        ultrasonic.addAccessory(new UltrasonicAccessory());
//        ds.createEntity(ultrasonic);
//        ultrasonic.doTest(test2, patient2);
//        System.out.println(test2.getResult());
//
//
//
//        ps.createPatient(patient1);
//        ps.createPatient(patient2);

//        System.out.println(ts.getAllTests());
//        System.out.println(ts.getPatientsWithGlucoseHigherThan(2.0));
    }
}
