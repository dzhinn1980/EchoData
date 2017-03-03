package ru.dzhinn.echodata.web.gwt.shared.dispatch.visit;

import com.gwtplatform.dispatch.rpc.shared.Result;
import ru.dzhinn.echodata.web.gwt.shared.dto.visit.VisitModel;

import java.util.List;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class GetVisitModelListResult implements Result {

    List<VisitModel> models;

    private GetVisitModelListResult() {
    }

    public GetVisitModelListResult(List<VisitModel> models) {
        this.models = models;
    }

    public List<VisitModel> getModels() {
        return models;
    }
}
