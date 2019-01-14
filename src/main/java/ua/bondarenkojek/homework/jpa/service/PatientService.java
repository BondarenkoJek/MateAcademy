package ua.bondarenkojek.homework.jpa.service;

import ua.bondarenkojek.homework.jpa.model.Patient;

public interface PatientService {
    Patient addPatient(Patient patient);

    Patient getPatient(Long id);

    void updatePatient(Patient patient);

    void deletePatient(Patient patient);
}
