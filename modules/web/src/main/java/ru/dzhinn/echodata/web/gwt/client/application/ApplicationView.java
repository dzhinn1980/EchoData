package ru.dzhinn.echodata.web.gwt.client.application;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {}

    @UiField
    FlowPanel topPanel;
    @UiField
    LayoutPanel navigationPanel;
    @UiField
    LayoutPanel contentPanel;

    @UiFactory
    SplitLayoutPanel setSplitterSize() {
        return new SplitLayoutPanel(5);
    }

    @Inject
    ApplicationView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

        bindSlot(ApplicationPresenter.SLOT_NAVIGATION, navigationPanel);
        bindSlot(ApplicationPresenter.SLOT_CONTENT, contentPanel);

        topPanel.add(new Label("topPanel"));
    }

}
