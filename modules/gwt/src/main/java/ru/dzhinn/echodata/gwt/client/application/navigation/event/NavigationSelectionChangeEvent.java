package ru.dzhinn.echodata.gwt.client.application.navigation.event;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by A.Dzhioev on 09.03.2017.
 */
public class NavigationSelectionChangeEvent extends GwtEvent<NavigationSelectionChangeEventHandler> {
    public static Type<NavigationSelectionChangeEventHandler> TYPE = new Type<NavigationSelectionChangeEventHandler>();

    public Type<NavigationSelectionChangeEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(NavigationSelectionChangeEventHandler handler) {
        handler.onNavigationSelectionChange(this);
    }
}
