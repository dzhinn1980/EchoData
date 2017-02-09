package ru.dzhinn.echodata.web.gwt.client.application.template.list;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TemplateListModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        bindPresenter(TemplateListPresenter.class, TemplateListPresenter.MyView.class, TemplateListView.class, TemplateListPresenter.MyProxy.class);
    }
}
