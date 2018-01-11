
package ru.dzhinn.echodata.gwt.client.application.test;

import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import java.util.ArrayList;
import java.util.List;

public class TabsView extends ViewWithUiHandlers<TabsUiHandlers> implements TabsPresenter.MyView {
    interface Binder extends UiBinder<LayoutPanel, TabsView> {
    }


    @UiField
    TabBar tabBar;
    @UiField
    ScrollPanel tabContent;
    @UiField
    FlowPanel tabContentLayoutPanel;

    List<TabInfo> tabInfoList = new ArrayList<>();
    TabInfo currentTab;

    @Inject
    TabsView(Binder binder) {

        initWidget(binder.createAndBindUi(this));



        tabBar.addSelectionHandler(new SelectionHandler<Integer>() {
            public void onSelection(SelectionEvent<Integer> event) {
                Integer selectedItemIndex = event.getSelectedItem();
                if (selectedItemIndex != null) {
                    currentTab = tabInfoList.get(event.getSelectedItem());
                    getUiHandlers().showTabContent(currentTab);
                }

            }
        });

        bindSlot(TabsPresenter.SLOT_CONTENT, tabContentLayoutPanel);

    }

    @Override
    public void setInSlot(Object slot, IsWidget content) {
        if (slot == TabsPresenter.SLOT_CONTENT) {
            tabContent.clear();
            tabContent.add(content);

        } else {
            super.setInSlot(slot, content);
        }
    }

    private void removeTab(int index){
        tabBar.removeTab(index);
//        tabIndexList.remove(index);
    }



    @Override
    public void activateTab(TabInfo tabInfo) {
        if (!tabInfoList.contains(tabInfo)){
            tabInfoList.add(tabInfo);
            addTab("Tab: " + tabInfo.getToken() + "-" + tabInfo.getTokenParam() + "-" + tabInfo.getTokenParamValue());
        } else {
            selectTab(tabInfoList.indexOf(tabInfo));
        }

        currentTab = tabInfo;

    }

    @Override
    public void resetTabs() {

//        if (tabInfoListcurrentTab != null);
//        for (TabInfo tabInfo : tabInfoList){
//            addTab(tabInfo);
//        }
    }

    private void addTab(String tabLabel){
        tabBar.addTab(tabLabel);
    }

    private void selectTab(int index){
        tabBar.selectTab(index);
    }


}
