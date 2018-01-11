
package ru.dzhinn.echodata.gwt.client.application.test;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.RevealContentEvent;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.gwt.client.application.test.events.AddMainTabEvent;
import ru.dzhinn.echodata.gwt.client.application.test.events.AddMainTabEventHandler;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;

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

//        Window.alert("TabsPresenter.onReset");

    }


    @Override
    protected void onBind() {
        super.onBind();

//        Window.alert("TabsPresenter.onBind");

        PlaceRequest request = placeManager.getCurrentPlaceRequest();

        for (String paramName : request.getParameterNames()){
            if (paramName.contains("tab-")){

                getView().activateTab(new TabInfo(NameTokens.VISIT, ParameterTokens.PATIENT_ID, request.getParameter(paramName, null)));
            }
        }


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
        placeManager.revealPlace(new PlaceRequest.Builder(placeManager.getCurrentPlaceRequest()).nameToken(tabInfo.getToken())
                .with(tabInfo.getTokenParam(), tabInfo.getTokenParamValue())
                .with(ParameterTokens.TAB_VISIT + tabInfo.getTokenParamValue(), tabInfo.getTokenParamValue())
                .build());
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ApplicationPresenter.SLOT_CONTENT, this);
    }


}
