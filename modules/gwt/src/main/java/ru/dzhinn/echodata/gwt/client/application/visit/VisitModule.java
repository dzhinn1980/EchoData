package ru.dzhinn.echodata.gwt.client.application.visit;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
//import ru.dzhinn.echodata.web.gwt.client.application.template.list.TemplateListModule;

public class VisitModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
//        install(new TemplateListModule());

        bindPresenter(VisitPresenter.class, VisitPresenter.MyView.class, VisitView.class, VisitPresenter.MyProxy.class);
    }
}
