package ru.dzhinn.echodata.web.gwt.shared.dispatch.template;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class GetTemplateModelListAction extends UnsecuredActionImpl<GetTemplateModelListResult> {

    private Long templateCategoryId;

    GetTemplateModelListAction() {
    }

    public GetTemplateModelListAction(Long templateCategoryId) {
        this.templateCategoryId = templateCategoryId;
    }

    public Long getTemplateCategoryId() {
        return templateCategoryId;
    }
}
