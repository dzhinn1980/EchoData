package ru.dzhinn.echodata.gwt.client.application;

import com.google.gwt.event.shared.GwtEvent;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.PermanentSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;
import ru.dzhinn.echodata.gwt.client.application.navigation.NavigationPresenter;
import ru.dzhinn.echodata.gwt.client.application.navigation.event.NavigationSelectionChangeEvent;
import ru.dzhinn.echodata.gwt.client.application.navigation.event.NavigationSelectionChangeEventHandler;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;


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
    private PlaceManager placeManager;

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

        addRegisteredHandler(NavigationSelectionChangeEvent.TYPE, new NavigationSelectionChangeEventHandler() {
            @Override
            public void onNavigationSelectionChange(NavigationSelectionChangeEvent event) {
                PlaceRequest placeRequest = new PlaceRequest.Builder()
                        .nameToken(NameTokens.VISIT)
                        .with(ParameterTokens.PATIENT_ID, "666")
                        .build();

                placeManager.revealPlace(placeRequest);
            }
        });
    }

}
