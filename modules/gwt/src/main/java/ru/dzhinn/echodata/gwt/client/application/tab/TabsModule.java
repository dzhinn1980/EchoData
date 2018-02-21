
package ru.dzhinn.echodata.gwt.client.application.tab;

import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;

public class TabsModule extends AbstractPresenterModule {
    @Override
    protected void configure() {

        bindPresenter(TabsPresenter.class, TabsPresenter.MyView.class, TabsView.class, TabsPresenter.MyProxy.class);
    }
}
