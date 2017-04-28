package ru.dzhinn.echodata.gwt.client.application.ui.tab;

import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.inject.Inject;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.ViewImpl;

/**
 * Created by A.Dzhioev on 28.04.2017.
 */
public class TabPanelView extends ViewImpl implements TabPanelPresenter.MyView {

    private final FlowPanel tabsContainer = new FlowPanel();
    private final FlowPanel contentContainer = new FlowPanel();

    @Inject
    public TabPanelView() {
        FlowPanel panel = new FlowPanel();
        panel.add(tabsContainer);
        panel.add(contentContainer);

        tabsContainer.add(new Label("tabsContainer"));

        initWidget(panel);
    }
}
