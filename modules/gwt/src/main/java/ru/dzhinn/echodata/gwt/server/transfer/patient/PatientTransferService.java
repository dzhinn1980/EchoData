package ru.dzhinn.echodata.gwt.server.transfer.patient;

import ru.dzhinn.echodata.persistent.model.patient.Patient;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 07.03.2017.
 */
public interface PatientTransferService {

    PatientModel toPatientModel(Patient patient);

    List<PatientModel> toPatientModels(List<Patient> patientList);
}
