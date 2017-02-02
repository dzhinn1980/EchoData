package ru.dzhinn.echodata.web.gwt.EchoData.gwt.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import ru.dzhinn.echodata.web.gwt.EchoData.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.web.gwt.EchoData.gwt.client.place.NameTokens;


public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
    interface MyView extends View {
    }


    @ProxyStandard
    @NameToken(NameTokens.HOME)
    interface MyProxy extends Proxy<HomePresenter> {
    }

//    public static final NestedSlot SLOT_HOME = new NestedSlot();

    @Inject
    HomePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_APPLICATION);

    }

}
