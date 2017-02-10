package ru.dzhinn.echodata.web.gwt.client.application.navigation;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.web.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.web.gwt.client.place.ParameterTokens;


public class NavigationPresenter extends Presenter<NavigationPresenter.MyView, NavigationPresenter.MyProxy> implements NavigationUiHandlers {
    interface MyView extends View, HasUiHandlers<NavigationUiHandlers> {
    }


    @ProxyStandard
    interface MyProxy extends Proxy<NavigationPresenter> {
    }

//    public static final NestedSlot SLOT_NAVIGATION = new NestedSlot();

    PlaceManager placeManager;

    @Inject
    NavigationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);


    }

    @Override
    public void onTemplateSelectionChange(String selected) {
        PlaceRequest placeRequest = new PlaceRequest.Builder()
                .nameToken(NameTokens.TEMPLATE)
                .with(ParameterTokens.TEMPLATE_CATEGORY_ID, selected)
                .build();

        placeManager.revealPlace(placeRequest);
    }
}
