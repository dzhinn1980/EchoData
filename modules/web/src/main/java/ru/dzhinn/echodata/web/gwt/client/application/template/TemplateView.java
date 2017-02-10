package ru.dzhinn.echodata.web.gwt.client.application.template;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.SplitLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;


public class TemplateView extends ViewWithUiHandlers<TemplateUiHandlers> implements TemplatePresenter.MyView {
    interface Binder extends UiBinder<Widget, TemplateView> {
    }

    @UiField
    SplitLayoutPanel splitLayoutPanel;

    @UiField
    LayoutPanel listPanel;

    @Inject
    TemplateView(Binder uiBinder) {
        initWidget(uiBinder.createAndBindUi(this));

//        splitLayoutPanel.insertNorth(new LayoutPanel(), splitLayoutPanel.getOffsetHeight()/3, listPanel);

        bindSlot(TemplatePresenter.SLOT_TEMPLATE, listPanel);
    }
}
