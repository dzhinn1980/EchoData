package ru.dzhinn.echodata.web.gwt.client.application.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;

import javax.inject.Inject;


public class HomeView extends ViewImpl implements HomePresenter.MyView {
//    interface Binder extends UiBinder<Widget, HomeView> {
//    }
//
//    @UiField
//    Label helloLabel;

    @Inject
    HomeView() {
//        initWidget(uiBinder.createAndBindUi(this));

//        bindSlot(HomePresenter.SLOT_HOME, main);

        String str = "str1234";

        Label label = new Label(str);

        initWidget(label);
    }
}
