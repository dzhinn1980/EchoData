package ru.dzhinn.echodata.web.gwt.client.application.home;

import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.Widget;
import com.gwtplatform.mvp.client.ViewImpl;
import ru.dzhinn.echodata.web.gwt.client.resources.AppResources;

import javax.inject.Inject;


public class HomeView extends ViewImpl implements HomePresenter.MyView {
    interface Binder extends UiBinder<Widget, HomeView> {
    }

//    @UiField
//    SimplePanel backgroundPanel;

//    @UiField(provided = true)
//    AppResources appResources;

//    @UiField
//    Button button;

    @Inject
    HomeView(Binder uiBinder) {


//        panel.add(new Button("b1"));
//        panel.add(new Label("l1"));



        initWidget(uiBinder.createAndBindUi(this));





//        bindSlot(HomePresenter.SLOT_HOME, main);

//        String str = "str1234";
//
//        Label label = new Label(str);
//
//        initWidget(label);
    }
}
