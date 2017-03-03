package ru.dzhinn.echodata.web.gwt.client.application;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import ru.dzhinn.echodata.web.gwt.client.application.home.HomeModule;
import ru.dzhinn.echodata.web.gwt.client.application.navigation.NavigationModule;
import ru.dzhinn.echodata.web.gwt.client.application.template.TemplateModule;
import ru.dzhinn.echodata.web.gwt.client.application.visit.VisitModule;

public class ApplicationModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

//        install(new VisitModule());
        install(new VisitModule());
        install(new TemplateModule());
        install(new NavigationModule());
        install(new HomeModule());

        bindPresenter(ApplicationPresenter.class, ApplicationPresenter.MyView.class, ApplicationView.class, ApplicationPresenter.MyProxy.class);
    }
}
