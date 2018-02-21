package ru.dzhinn.echodata.gwt.client.application.tab;

import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.*;

/**
 * Created by A.Dzhioev on 15.02.2018.
 */
public class TabWidget extends Composite {

    private Label label = new Label("");
    private Anchor closeAnchor = new Anchor("x");
    private TabInfo tabInfo;

    public TabWidget(TabInfo tabInfo) {

        this.tabInfo = tabInfo;

        HorizontalPanel panel = new HorizontalPanel();
        panel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);

        label.setText("Tab: " + tabInfo.getToken() + "-" + tabInfo.getTokenParam() + "-" + tabInfo.getTabParamValue());

        panel.add(label);
        panel.add(closeAnchor);

        initWidget(panel);
    }

    public TabInfo getTabInfo() {
        return tabInfo;
    }

    public void addCloseClickHandler(ClickHandler handler){
        closeAnchor.addClickHandler(handler);
    }
}
