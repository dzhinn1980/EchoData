package ru.dzhinn.echodata.web.transfer.patient;

import ru.dzhinn.echodata.persistent.model.patient.Patient;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 07.03.2017.
 */
public interface PatientTransferService {

    PatientModel toPatientModel(Patient patient);

    List<PatientModel> toPatientModels(List<Patient> patientList);
}
