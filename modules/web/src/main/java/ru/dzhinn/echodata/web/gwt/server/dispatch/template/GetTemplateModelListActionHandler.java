package ru.dzhinn.echodata.web.gwt.server.dispatch.template;

import com.gwtplatform.dispatch.rpc.server.ExecutionContext;
import com.gwtplatform.dispatch.rpc.server.actionhandler.ActionHandler;
import com.gwtplatform.dispatch.shared.ActionException;
import org.springframework.stereotype.Component;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.template.GetTemplateModelListAction;
import ru.dzhinn.echodata.web.gwt.shared.dispatch.template.GetTemplateModelListResult;
import ru.dzhinn.echodata.web.gwt.shared.dto.template.TemplateModel;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetTemplateModelListActionHandler implements ActionHandler<GetTemplateModelListAction, GetTemplateModelListResult> {
    @Override
    public GetTemplateModelListResult execute(GetTemplateModelListAction action, ExecutionContext context) throws ActionException {
        List<TemplateModel> models = new ArrayList<>();
        for (int i = 0; i < 20; i++){
            models.add(new TemplateModel(Long.valueOf(i), "Template #" + i));
        }
        return new GetTemplateModelListResult(models);
    }

    @Override
    public Class<GetTemplateModelListAction> getActionType() {
        return GetTemplateModelListAction.class;
    }

    @Override
    public void undo(GetTemplateModelListAction action, GetTemplateModelListResult result, ExecutionContext context) throws ActionException {

    }
}
