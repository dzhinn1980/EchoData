
package ru.dzhinn.echodata.gwt.client.application.tab;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.SelectionEvent;
import com.google.gwt.event.logical.shared.SelectionHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;
import ru.dzhinn.echodata.gwt.client.resources.TabMessages;

import java.util.ArrayList;
import java.util.List;

public class TabsView extends ViewWithUiHandlers<TabsUiHandlers> implements TabsPresenter.MyView {
    interface Binder extends UiBinder<LayoutPanel, TabsView> {
    }


    @UiField
    LayoutPanel tabsPanel;
    @UiField
    ScrollPanel tabBarScrollPanel;
    @UiField
    TabBar tabBar;
    @UiField
    ScrollPanel tabContent;
    @UiField
    FlowPanel tabContentLayoutPanel;

    List<TabInfo> tabInfoList = new ArrayList<>();
    TabInfo currentTab;

    private TabMessages messages;

//    boolean deleteClicked = false;

    @Inject
    TabsView(Binder binder, TabMessages messages) {
        this.messages = messages;

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


    @Override
    public void activateTab(TabInfo tabInfo) {

        if (tabInfo == null) return;

        if (!tabInfoList.contains(tabInfo)){
            tabInfoList.add(tabInfo);
            addTab(tabInfo);
        }

        selectTab(tabInfoList.indexOf(tabInfo));

        currentTab = tabInfo;

    }


    private void addTab(TabInfo tabInfo){
        TabWidget tabWidget = new TabWidget(tabInfo);

        tabWidget.addCloseClickHandler(new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                TabInfo tabForDelete = tabWidget.getTabInfo();

                if (Window.confirm(messages.confirmRemoveTab(tabForDelete.getTabParam() + tabForDelete.getTabParamValue()))) {
                    int tabForDeleteIndex = tabInfoList.indexOf(tabForDelete);
                    tabBar.removeTab(tabForDeleteIndex);
                    tabInfoList.remove(tabForDelete);
                    if (tabForDelete != currentTab) {
                        getUiHandlers().onRemoveTab(tabForDelete, currentTab);
                        activateTab(currentTab);
                    } else {
                        if (tabForDeleteIndex > 0) {
                            getUiHandlers().onRemoveTab(tabForDelete, tabInfoList.get(tabForDeleteIndex - 1));
                            currentTab = tabInfoList.get(tabForDeleteIndex - 1);
                            activateTab(currentTab);
                        } else if (tabForDeleteIndex == 0) {
                            getUiHandlers().onRemoveLastTab();
                            currentTab = null;
//                            tabsPanel.clear();
                        }
                    }

                }

            }
        });

        tabBar.addTab(tabWidget);
    }

    private void selectTab(int index){
        tabBar.selectTab(index);
    }


}
