package ru.dzhinn.echodata.web.gwt.client.application;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.*;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class ApplicationView extends ViewImpl implements ApplicationPresenter.MyView {
    interface Binder extends UiBinder<Widget, ApplicationView> {
    }

//    @UiField
//    SplitLayoutPanel main;

    private final Widget container;

    @UiField
    FlowPanel topPanel;
//    @UiField
//    EchoDataNavigation navigationPanel;
    @UiField
    FlowPanel listPanel;
    @UiField
    FlowPanel contentPanel;

    @UiFactory
    SplitLayoutPanel makeCricketScores() { // method name is insignificant
        return new SplitLayoutPanel(5);
    }

    @Inject
    ApplicationView(Binder uiBinder) {
        container = uiBinder.createAndBindUi(this);

        topPanel.add(new Label("topPanel"));
//        navigationPanel.add(new Label("navigationPanel"));
        listPanel.add(new Label("listPanel"));

        bindSlot(ApplicationPresenter.SLOT_APPLICATION, contentPanel);
    }

    @Override
    public Widget asWidget() {
        return container;
    }
}
