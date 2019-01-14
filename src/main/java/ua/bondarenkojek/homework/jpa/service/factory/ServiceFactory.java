package ua.bondarenkojek.homework.jpa.service.factory;

import ua.bondarenkojek.homework.jpa.dao.impl.DeviceDaoImpl;
import ua.bondarenkojek.homework.jpa.dao.impl.PatientDaoImpl;
import ua.bondarenkojek.homework.jpa.dao.impl.TestDaoImpl;
import ua.bondarenkojek.homework.jpa.service.DeviceService;
import ua.bondarenkojek.homework.jpa.service.PatientService;
import ua.bondarenkojek.homework.jpa.service.TestService;
import ua.bondarenkojek.homework.jpa.service.impl.DeviceServiceImpl;
import ua.bondarenkojek.homework.jpa.service.impl.PatientServiceImpl;
import ua.bondarenkojek.homework.jpa.service.impl.TestServiceImpl;
import ua.bondarenkojek.homework.jpa.util.HibernateUtil;

import javax.persistence.EntityManager;

public class ServiceFactory {
    private static final EntityManager entityManager;

    static {
        entityManager = HibernateUtil.getEntityManager();
    }

    public static DeviceService getDeviseService() {
        return new DeviceServiceImpl(new DeviceDaoImpl(entityManager));
    }

    public static PatientService getPatientService() {
        return new PatientServiceImpl(new PatientDaoImpl(entityManager));
    }

    public static TestService getTestService() {
        return new TestServiceImpl(new TestDaoImpl(entityManager));
    }
}
