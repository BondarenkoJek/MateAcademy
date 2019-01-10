package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.Patient;

public interface PatientService {
    Long createPatient(Patient patient);

    Patient readPatient(Long id);

    void updatePatient(Patient patient);

    void deletePatient(Patient patient);
}
