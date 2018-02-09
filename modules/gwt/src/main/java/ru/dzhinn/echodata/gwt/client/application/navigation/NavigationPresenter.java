package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.ProxyStandard;
import com.gwtplatform.mvp.client.proxy.PlaceManager;
import com.gwtplatform.mvp.client.proxy.Proxy;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;
import ru.dzhinn.echodata.gwt.client.application.test.TabInfo;
import ru.dzhinn.echodata.gwt.client.application.test.events.AddMainTabEvent;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;
import ru.dzhinn.echodata.gwt.shared.dispatch.patient.GetPatientListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListResult;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.shared.dispatch.patient.GetPatientListResult;

import java.util.List;


public class NavigationPresenter extends Presenter<NavigationPresenter.MyView, NavigationPresenter.MyProxy> implements NavigationUiHandlers {
    interface MyView extends View, HasUiHandlers<NavigationUiHandlers> {
        void setPatientList(List<PatientModel> models);

        void setHighLevelTemplateList(List<TemplateTreeModel> models);
    }


    @ProxyStandard
    interface MyProxy extends Proxy<NavigationPresenter> {
    }


    @Inject
    private DispatchAsync dispatch;

    PlaceManager placeManager;

    @Inject
    NavigationPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy,
            PlaceManager placeManager) {
        super(eventBus, view, proxy);

        this.placeManager = placeManager;

        getView().setUiHandlers(this);


    }

    @Override
    protected void onBind() {
        super.onBind();

        dispatch.execute(new GetPatientListAction(1L), new AsyncCallback<GetPatientListResult>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("hyi");
            }

            @Override
            public void onSuccess(GetPatientListResult result) {
                getView().setPatientList(result.getModels());
            }
        });

        dispatch.execute(new GetChildTemplateListAction(), new AsyncCallback<GetChildTemplateListResult>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("GetChildTemplateListAction hyi");
            }

            @Override
            public void onSuccess(GetChildTemplateListResult result) {
                getView().setHighLevelTemplateList(result.getModels());
            }
        });
    }

    @Override
    public void onTemplateSelectionChange(String selected) {
//        PlaceRequest placeRequest = new PlaceRequest.Builder()
//                .nameToken(NameTokens.TEMPLATE)
//                .with(ParameterTokens.TEMPLATE_CATEGORY_ID, selected)
//                .build();
//
//        placeManager.revealPlace(placeRequest);
        Window.alert("onTemplateSelectionChange");
    }

    @Override
    public void patientSelectionChange(PatientModel model) {
        if (model != null) {

            fireEvent(new AddMainTabEvent(new TabInfo(NameTokens.VISIT, ParameterTokens.PATIENT_ID, model.getId().toString())));
        }
    }
}
