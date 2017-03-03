package ru.dzhinn.echodata.web.gwt.shared.dispatch.patient;

import com.gwtplatform.dispatch.rpc.shared.Result;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 22.02.2017.
 */
public class GetPatientListResult implements Result {
    List<PatientModel> models;

    private GetPatientListResult() {
    }

    public GetPatientListResult(List<PatientModel> models) {
        this.models = models;
    }

    public List<PatientModel> getModels() {
        return models;
    }
}
