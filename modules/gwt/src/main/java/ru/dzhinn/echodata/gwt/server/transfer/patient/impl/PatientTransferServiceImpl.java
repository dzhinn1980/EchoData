package ru.dzhinn.echodata.gwt.server.transfer.patient.impl;

import org.springframework.stereotype.Service;
import ru.dzhinn.echodata.gwt.server.transfer.DateUtil;
import ru.dzhinn.echodata.gwt.server.transfer.patient.PatientTransferService;
import ru.dzhinn.echodata.persistent.model.patient.Patient;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientTransferServiceImpl implements PatientTransferService {
    @Override
    public PatientModel toPatientModel(Patient patient) {
        PatientModel result = new PatientModel();
        result.setId(patient.getId());
        result.setFullName(patient.getFullName());
        result.setDateOfBirth(patient.getDateOfBirth() != null ? DateUtil.formatSimpleDate(patient.getDateOfBirth()) : "");
        return result;
    }

    @Override
    public List<PatientModel> toPatientModels(List<Patient> patientList) {
        List<PatientModel> result = new ArrayList<>();
        for (Patient patient : patientList){
            result.add(toPatientModel(patient));
        }
        return result;
    }
}
