package ru.dzhinn.echodata.gwt.client.application.ui.tab.events;

import com.google.gwt.event.shared.GwtEvent;
import ru.dzhinn.echodata.gwt.client.application.ui.tab.TabInfo;

/**
 * Created by A.Dzhioev on 13.12.2017.
 */
public class AddMainTabEvent extends GwtEvent<AddMainTabEventHandler> {
    public static Type<AddMainTabEventHandler> TYPE = new Type<AddMainTabEventHandler>();

    private TabInfo tabInfo;


    public AddMainTabEvent(TabInfo tabInfo) {
        this.tabInfo = tabInfo;
    }

    public TabInfo getTabInfo() {
        return tabInfo;
    }

    public Type<AddMainTabEventHandler> getAssociatedType() {
        return TYPE;
    }

    protected void dispatch(AddMainTabEventHandler handler) {
        handler.onAdd(this);
    }
}
