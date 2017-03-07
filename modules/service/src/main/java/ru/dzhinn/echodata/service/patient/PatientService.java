package ru.dzhinn.echodata.service.patient;

import ru.dzhinn.echodata.persistent.model.patient.Patient;

import java.util.List;

/**
 * Created by A.Dzhioev on 06.03.2017.
 */
public interface PatientService {
    List<Patient> getPatientList(Long userId);
}
