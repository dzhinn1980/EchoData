package ru.dzhinn.echodata.web.gwt.client.application.home;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.dzhinn.echodata.web.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;
//import ru.dzhinn.echodata.web.gwt.gwtp.client.NameTokens;
//import ru.dzhinn.echodata.web.gwt.gwtp.client.application.ApplicationPresenter;

public class HomePresenter extends Presenter<HomePresenter.MyView, HomePresenter.MyProxy> {
    interface MyView extends View {
    }

    @NameToken(NameTokens.HOME)
    @ProxyStandard
    interface MyProxy extends ProxyPlace<HomePresenter> {
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
