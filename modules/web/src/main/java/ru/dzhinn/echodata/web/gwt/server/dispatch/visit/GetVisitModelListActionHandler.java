package ru.dzhinn.echodata.web.gwt.server.dispatch.visit;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import org.springframework.stereotype.Component;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.visit.GetVisitModelListAction;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.visit.GetVisitModelListResult;
import ru.dzhinn.echodata.web.gwt.shared.dto.visit.VisitModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class GetVisitModelListActionHandler implements ActionHandler<GetVisitModelListAction, GetVisitModelListResult> {
    @Override
    public GetVisitModelListResult execute(GetVisitModelListAction action, ExecutionContext context) throws ActionException {
        List<VisitModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            models.add(new VisitModel(Long.valueOf(i), new Date(2017, 1, i)));
        }
        return new GetVisitModelListResult(models);
    }

    @Override
    public Class<GetVisitModelListAction> getActionType() {
        return GetVisitModelListAction.class;
    }

    @Override
    public void undo(GetVisitModelListAction action, GetVisitModelListResult result, ExecutionContext context) throws ActionException {

    }
}