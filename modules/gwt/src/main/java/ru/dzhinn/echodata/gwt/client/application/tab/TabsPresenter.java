
package ru.dzhinn.echodata.gwt.client.application.tab;

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
import ru.dzhinn.echodata.gwt.client.application.events.ClearTabsEvent;
import ru.dzhinn.echodata.gwt.client.application.tab.events.AddMainTabEvent;
import ru.dzhinn.echodata.gwt.client.application.tab.events.AddMainTabEventHandler;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;

public class TabsPresenter extends Presenter<TabsPresenter.MyView, TabsPresenter.MyProxy> implements TabsUiHandlers {
    interface MyView extends View, HasUiHandlers<TabsUiHandlers> {
        void activateTab(TabInfo tabInfo);
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

        PlaceRequest request = placeManager.getCurrentPlaceRequest();

        boolean hasTabs = false;
        for (String paramName : request.getParameterNames()){
            if (paramName.contains("tab-")){
                getView().activateTab(TabInfo.getTabInfoByParamName(paramName, request.getParameter(paramName, null)));
                if (!hasTabs) {
                    hasTabs = true;
                }
            }
        }

        if (hasTabs) {
            TabTypeEnum tabType = TabTypeEnum.byToken(request.getNameToken());
            getView().activateTab(new TabInfo(tabType, request.getParameter(ParameterTokens.CURRENT_ID, null)));
        }

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
                .with(ParameterTokens.CURRENT_ID, tabInfo.getTabParamValue())
                .with(tabInfo.getTabParam() + tabInfo.getTabParamValue(), tabInfo.getTabParamValue())
                .build());
    }

    @Override
    public void onRemoveTab(TabInfo tabForDelete, TabInfo currentTab) {
        placeManager.revealPlace(new PlaceRequest.Builder(placeManager.getCurrentPlaceRequest())
                .nameToken(currentTab.getToken())
                .with(ParameterTokens.CURRENT_ID, currentTab.getTabParamValue())
                .without(tabForDelete.getTabParam() + tabForDelete.getTabParamValue())
                .build());
    }

    @Override
    public void onRemoveLastTab() {
//        placeManager.revealPlace(new PlaceRequest.Builder().nameToken(NameTokens.HOME).build());
        fireEvent(new ClearTabsEvent());
    }

    @Override
    protected void revealInParent() {
        RevealContentEvent.fire(this, ApplicationPresenter.SLOT_CONTENT, this);
    }


}
