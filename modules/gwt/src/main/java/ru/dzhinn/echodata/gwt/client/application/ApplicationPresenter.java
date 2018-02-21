package ru.dzhinn.echodata.gwt.client.application;

import com.google.gwt.user.client.Window;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.gwt.client.application.events.ClearTabsEvent;
import ru.dzhinn.echodata.gwt.client.application.events.ClearTabsEventHandler;
import ru.dzhinn.echodata.gwt.client.application.navigation.NavigationPresenter;
import ru.dzhinn.echodata.gwt.client.application.tab.TabsPresenter;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;


public class ApplicationPresenter extends Presenter<ApplicationPresenter.MyView, ApplicationPresenter.MyProxy> implements ApplicationUiHandlers {
    interface MyView extends View, HasUiHandlers<ApplicationUiHandlers> {
        void clearTabs();
    }

    @ProxyStandard
    interface MyProxy extends Proxy<ApplicationPresenter> {
    }

//    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    static final PermanentSlot<NavigationPresenter> SLOT_NAVIGATION = new PermanentSlot<>();
    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    public static final NestedSlot SLOT_TEST = new NestedSlot();

    @Inject
    private NavigationPresenter navigationPresenter;
    @Inject
    private TabsPresenter testPresenter;

    PlaceManager placeManager;

    @Inject
    ApplicationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy, RevealType.RootLayout);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(SLOT_NAVIGATION, navigationPresenter);

        addRegisteredHandler(ClearTabsEvent.TYPE, new ClearTabsEventHandler() {
            @Override
            public void onClearTabs(ClearTabsEvent event) {
                getView().clearTabs();
            }
        });

    }

    @Override
    public void onLogoImageClick() {
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.HOME).build());
        getView().clearTabs();
//        placeManager.revealDefaultPlace();
    }
}
