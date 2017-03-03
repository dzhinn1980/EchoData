package ru.dzhinn.echodata.web.gwt.server.dispatch.patient;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.AbstractActionHandler;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import org.springframework.stereotype.Component;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.patient.GetPatientListAction;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.patient.GetPatientListResult;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetPatientListActionHandler implements ActionHandler<GetPatientListAction, GetPatientListResult> {
    @Override
    public GetPatientListResult execute(GetPatientListAction action, ExecutionContext context) throws ActionException {
        List<PatientModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            models.add(new PatientModel(Long.valueOf(i), "Familia Imia Otchestvo" + i, String.valueOf(1980 + i)));
        }
        return new GetPatientListResult(models);
    }

    @Override
    public Class<GetPatientListAction> getActionType() {
        return GetPatientListAction.class;
    }

    @Override
    public void undo(GetPatientListAction action, GetPatientListResult result, ExecutionContext context) throws ActionException {

    }

//    @Autowired
//    private ServletContext servletContext;



//    public GetPatientListActionHandler(Class<GetPatientListAction> actionType) {
//        super(actionType);
//    }
//
//    @Override
//    public GetPatientListResult execute(GetPatientListAction action, ExecutionContext context) throws ActionException {
//        List<PatientModel> models = new ArrayList<>();
//        for (int i = 0; i < 20; i++){
//            models.add(new PatientModel("Familia Imia Otchestvo" + i, String.valueOf(1980 + i)));
//        }
//        return new GetPatientListResult();
//    }
//
//    @Override
//    public void undo(GetPatientListAction action, GetPatientListResult result, ExecutionContext context) throws ActionException {
//
//    }
}
