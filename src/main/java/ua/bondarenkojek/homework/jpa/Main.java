package ua.bondarenkojek.homework.jpa;

import ua.bondarenkojek.homework.jpa.dao.impl.PatientDaoImpl;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.model.test.BloodTest;
import ua.bondarenkojek.homework.jpa.model.test.Test;
import ua.bondarenkojek.homework.jpa.service.PatientService;
import ua.bondarenkojek.homework.jpa.service.impl.PatientServiceImpl;
import ua.bondarenkojek.homework.jpa.util.HibernateUtil;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
//        PatientService ps = new PatientServiceImpl(
//                new PatientDaoImpl(HibernateUtil.getEntityManager()));
//
//        Patient patient = Patient
//                .builder()
//                .name("Jek")
//                .dateOfBirth(LocalDate.of(1992, 1, 7))
//                .build();
//        System.out.println(ps.createPatient(patient));

//        System.out.println(ps.readPatient(1L));
    }
}
