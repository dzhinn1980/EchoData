package ru.dzhinn.echodata.gwt.client.application.events;

import com.google.gwt.event.shared.GwtEvent;

/**
 * Created by A.Dzhioev on 21.02.2018.
 */
public class ClearTabsEvent extends GwtEvent<ClearTabsEventHandler> {
    public static Type<ClearTabsEventHandler> TYPE = new Type<ClearTabsEventHandler>();

    public Type<ClearTabsEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(ClearTabsEventHandler handler) {
        handler.onClearTabs(this);
    }
}
