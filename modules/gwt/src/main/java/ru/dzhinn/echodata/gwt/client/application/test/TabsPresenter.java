
package ru.dzhinn.echodata.gwt.client.application.test;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.gwt.client.application.ui.tab.TabInfo;
import ru.dzhinn.echodata.gwt.client.application.ui.tab.events.AddMainTabEvent;
import ru.dzhinn.echodata.gwt.client.application.ui.tab.events.AddMainTabEventHandler;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;

public class TabsPresenter extends Presenter<TabsPresenter.MyView, TabsPresenter.MyProxy> implements TabsUiHandlers {
    interface MyView extends View, HasUiHandlers<TabsUiHandlers> {
//        void addTab(String tabLabel);
//        void selectTab(int index);
        void activateTab(TabInfo tabInfo);
        void resetTabs();
    }

//    @NameToken(NameTokens.TABS)
    @ProxyCodeSplit
    interface MyProxy extends Proxy<TabsPresenter> {
    }

    public static final NestedSlot SLOT_CONTENT = new NestedSlot();

    PlaceManager placeManager;

    @Inject
    TabsPresenter(EventBus eventBus,
                  MyView view,
                  MyProxy proxy,
                  PlaceManager placeManager) {
        super(eventBus, view, proxy);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);

    }

    @Override
    protected void onReset() {
        super.onReset();

    }


    @Override
    protected void onBind() {
        super.onBind();


        getView().resetTabs();

        addRegisteredHandler(AddMainTabEvent.TYPE, new AddMainTabEventHandler() {
            @Override
            public void onAdd(AddMainTabEvent event) {
                getView().activateTab(event.getTabInfo());
                showTabContent(event.getTabInfo());
            }
        });

    }

    public void showTabContent(TabInfo tabInfo){
        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(tabInfo.getToken())
                .with(tabInfo.getTokenParam(), tabInfo.getTokenParamValue())
                .build());
    }


}
