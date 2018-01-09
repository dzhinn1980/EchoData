package ru.dzhinn.echodata.dao.patient;

import org.springframework.stereotype.Repository;
import ru.dzhinn.echodata.persistent.model.patient.Patient;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class PatientDAO {

    public List<Patient> getPatientList(Long userId) {
        List<Patient> result = new ArrayList<>();
//        Patient patient;
        for (int i = 0; i < 20; i++){
            Patient patient = new Patient();
            patient.setId((long) i);
            String fullName = "Familia Imia Otchestvo" + i;
            patient.setFullName(fullName);
            patient.setDateOfBirth(new Date(userId + i));
            result.add(patient);
        }

        return result;
    }

}
