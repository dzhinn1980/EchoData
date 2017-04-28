package ru.dzhinn.echodata.gwt.shared.dispatch.template;

import com.gwtplatform.dispatch.rpc.shared.Result;
import ru.dzhinn.echodata.gwt.shared.dto.template.TemplateModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class GetTemplateModelListResult implements Result {

    List<TemplateModel> models;

    private GetTemplateModelListResult() {
    }

    public GetTemplateModelListResult(List<TemplateModel> models) {
        this.models = models;
    }

    public List<TemplateModel> getModels() {
        return models;
    }
}
