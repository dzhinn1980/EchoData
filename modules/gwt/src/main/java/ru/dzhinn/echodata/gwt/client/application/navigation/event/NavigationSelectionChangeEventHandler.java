package ru.dzhinn.echodata.gwt.client.application.navigation.event;

import com.google.gwt.event.shared.EventHandler;

/**
 * Created by A.Dzhioev on 09.03.2017.
 */
public interface NavigationSelectionChangeEventHandler extends EventHandler {
    void onNavigationSelectionChange(NavigationSelectionChangeEvent event);
}
