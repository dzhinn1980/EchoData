package ru.dzhinn.echodata.web.gwt.server.dispatch.patient;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.AbstractActionHandler;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dzhinn.echodata.service.patient.PatientService;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.patient.GetPatientListAction;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.patient.GetPatientListResult;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;
import ru.dzhinn.echodata.web.transfer.patient.PatientTransferService;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPatientListActionHandler implements ActionHandler<GetPatientListAction, GetPatientListResult> {

    @Autowired
    PatientService patientService;

    @Autowired
    PatientTransferService patientTransferService;

    @Override
    public GetPatientListResult execute(GetPatientListAction action, ExecutionContext context) throws ActionException {
//        List<PatientModel> models = new ArrayList<>();
//        for (int i = 0; i < 20; i++){
//            models.add(new PatientModel(Long.valueOf(i), "Familia Imia Otchestvo" + i, String.valueOf(1980 + i)));
//        }
        return new GetPatientListResult(patientTransferService.toPatientModels(patientService.getPatientList(action.getUserId())));
    }

    @Override
    public Class<GetPatientListAction> getActionType() {
        return GetPatientListAction.class;
    }

    @Override
    public void undo(GetPatientListAction action, GetPatientListResult result, ExecutionContext context) throws ActionException {

    }


}
