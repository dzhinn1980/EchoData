package ru.dzhinn.echodata.gwt.client.application.tab;

import com.gwtplatform.mvp.client.UiHandlers;

/**
 * Created by A.Dzhioev on 09.01.2018.
 */
public interface TabsUiHandlers extends UiHandlers {
    void showTabContent(TabInfo tabInfo);

    void onRemoveTab(TabInfo tabForDelete, TabInfo currentTab);

    void onRemoveLastTab();
}
