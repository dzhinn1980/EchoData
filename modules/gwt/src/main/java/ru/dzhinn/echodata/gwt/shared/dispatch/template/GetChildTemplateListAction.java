package ru.dzhinn.echodata.gwt.shared.dispatch.template;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;

/**
 * Created by A.Dzhioev on 09.02.2018.
 */
public class GetChildTemplateListAction extends UnsecuredActionImpl<GetChildTemplateListResult> {

    private Long parentId;

    public GetChildTemplateListAction() {
    }

    public GetChildTemplateListAction(Long parentId) {
        this.parentId = parentId;
    }

    public Long getParentId() {
        return parentId;
    }
}
