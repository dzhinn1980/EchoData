package ru.dzhinn.echodata.gwt.server.dispatch.template;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListResult;
import ru.dzhinn.echodata.service.template.TemplateService;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetChildTemplateListActionHandler implements ActionHandler<GetChildTemplateListAction, GetChildTemplateListResult> {

//    @Autowired
//    TemplateService service;

    @Override
    public GetChildTemplateListResult execute(GetChildTemplateListAction action, ExecutionContext context) throws ActionException {
        List<TemplateTreeModel> models = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            models.add(new TemplateTreeModel("Template : " + i));
        }
        return new GetChildTemplateListResult(models);
    }

    @Override
    public Class<GetChildTemplateListAction> getActionType() {
        return GetChildTemplateListAction.class;
    }

    @Override
    public void undo(GetChildTemplateListAction action, GetChildTemplateListResult result, ExecutionContext context) throws ActionException {

    }


}