
package ru.dzhinn.echodata.gwt.client.application.test;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TabsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(TabsPresenter.class, TabsPresenter.MyView.class, TabsView.class, TabsPresenter.MyProxy.class);
    }
}
