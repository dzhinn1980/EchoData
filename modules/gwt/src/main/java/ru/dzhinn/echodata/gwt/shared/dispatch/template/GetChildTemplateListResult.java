package ru.dzhinn.echodata.gwt.shared.dispatch.template;

import com.gwtplatform.dispatch.rpc.shared.Result;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 09.02.2018.
 */
public class GetChildTemplateListResult implements Result {
    List<TemplateTreeModel> models;

    private GetChildTemplateListResult() {
    }

    public GetChildTemplateListResult(List<TemplateTreeModel> models) {
        this.models = models;
    }

    public List<TemplateTreeModel> getModels() {
        return models;
    }
}
