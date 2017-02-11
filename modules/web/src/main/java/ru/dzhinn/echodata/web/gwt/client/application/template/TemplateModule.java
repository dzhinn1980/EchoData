package ru.dzhinn.echodata.web.gwt.client.application.template;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
//import ru.dzhinn.echodata.web.gwt.client.application.template.list.TemplateListModule;

public class TemplateModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
//        install(new TemplateListModule());

        bindPresenter(TemplatePresenter.class, TemplatePresenter.MyView.class, TemplateView.class, TemplatePresenter.MyProxy.class);
    }
}
