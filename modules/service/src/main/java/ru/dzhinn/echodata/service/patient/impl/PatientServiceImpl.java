package ru.dzhinn.echodata.service.patient.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.dzhinn.echodata.dao.patient.PatientDAO;
import ru.dzhinn.echodata.persistent.model.patient.Patient;
import ru.dzhinn.echodata.service.patient.PatientService;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatientDAO patientDAO;

    @Override
    public List<Patient> getPatientList(Long userId) {
        return patientDAO.getPatientList(userId);
    }
}
