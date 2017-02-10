package ru.dzhinn.echodata.web.gwt.client.application.template.list;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewWithUiHandlers;

import javax.inject.Inject;


public class TemplateListView extends ViewWithUiHandlers<TemplateListUiHandlers> implements TemplateListPresenter.MyView {
    interface Binder extends UiBinder<Widget, TemplateListView> {
    }

    @UiField
    SimplePanel main;


    @Inject
    TemplateListView(Binder uiBinder) {

//

        initWidget(uiBinder.createAndBindUi(this));

        main.add(new Label("TemplateListView"));

//        bindSlot(TemplateListPresenter.SLOT_TEMPLATELIST, main);
    }
}
