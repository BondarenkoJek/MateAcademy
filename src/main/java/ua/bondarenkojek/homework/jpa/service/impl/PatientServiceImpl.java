package ua.bondarenkojek.homework.jpa.service.impl;

import ua.bondarenkojek.homework.jpa.dao.PatientDao;
import ua.bondarenkojek.homework.jpa.model.Patient;
import ua.bondarenkojek.homework.jpa.service.PatientService;

public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;

    public PatientServiceImpl(PatientDao patientDao) {
        this.patientDao = patientDao;
    }

    @Override
    public Long createPatient(Patient patient) {
        return patientDao.createEntity(patient);
    }

    @Override
    public Patient readPatient(Long id) {
        return patientDao.readEntity(id);
    }

    @Override
    public void updatePatient(Patient patient) {
        patientDao.updateEntity(patient);
    }

    @Override
    public void deletePatient(Patient patient) {
        patientDao.deleteEntity(patient);
    }
}
