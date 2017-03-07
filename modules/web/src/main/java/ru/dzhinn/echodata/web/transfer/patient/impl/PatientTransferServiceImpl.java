package ru.dzhinn.echodata.web.transfer.patient.impl;

import org.springframework.stereotype.Service;
import ru.dzhinn.echodata.persistent.model.patient.Patient;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;
import ru.dzhinn.echodata.web.transfer.DateUtil;
import ru.dzhinn.echodata.web.transfer.patient.PatientTransferService;

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
