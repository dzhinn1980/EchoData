package ru.dzhinn.echodata.gwt.client.application.test;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.dzhinn.echodata.gwt.client.application.ui.tab.TabInfo;

/**
 * Created by A.Dzhioev on 09.01.2018.
 */
public interface TabsUiHandlers extends UiHandlers {
    void showTabContent(TabInfo tabInfo);
}
