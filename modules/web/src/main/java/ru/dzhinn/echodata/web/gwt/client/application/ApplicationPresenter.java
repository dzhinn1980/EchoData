package ru.dzhinn.echodata.web.gwt.client.application;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import ru.dzhinn.echodata.web.gwt.client.application.navigation.NavigationPresenter;


public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    interface MyView extends View {
    }


    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    static final PermanentSlot<NavigationPresenter> SLOT_NAVIGATION = new PermanentSlot<>();

    @Inject
    private NavigationPresenter navigationPresenter;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, RevealType.RootLayout);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(SLOT_NAVIGATION, navigationPresenter);
    }
}
