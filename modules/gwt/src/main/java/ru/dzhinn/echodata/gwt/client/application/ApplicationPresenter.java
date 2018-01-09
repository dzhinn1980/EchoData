package ru.dzhinn.echodata.gwt.client.application;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.Proxy;
import ru.dzhinn.echodata.gwt.client.application.navigation.NavigationPresenter;
import ru.dzhinn.echodata.gwt.client.application.test.TabsPresenter;


public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> {
    interface MyView extends View {
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

//    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    static final PermanentSlot<NavigationPresenter> SLOT_NAVIGATION = new PermanentSlot<>();
    static final PermanentSlot<TabsPresenter> SLOT_CONTENT = new PermanentSlot<>();

    public static final NestedSlot SLOT_TEST = new NestedSlot();

    @Inject
    private NavigationPresenter navigationPresenter;
    @Inject
    private TabsPresenter testPresenter;

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
        setInSlot(SLOT_CONTENT, testPresenter);

    }

}
