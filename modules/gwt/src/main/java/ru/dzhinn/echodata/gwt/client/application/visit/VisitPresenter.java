package ru.dzhinn.echodata.gwt.client.application.visit;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.dispatch.rpc.shared.DispatchAsync;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import com.gwtplatform.mvp.shared.proxy.PlaceRequest;
import ru.dzhinn.echodata.gwt.client.application.test.TabsPresenter;
import ru.dzhinn.echodata.gwt.client.place.ParameterTokens;
import ru.dzhinn.echodata.gwt.shared.dispatch.visit.GetVisitModelListAction;
import ru.dzhinn.echodata.gwt.shared.dto.visit.VisitModel;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.shared.dispatch.visit.GetVisitModelListResult;

import java.util.List;

public class VisitPresenter extends Presenter<VisitPresenter.MyView, VisitPresenter.MyProxy> implements VisitUiHandlers {
    interface MyView extends View, HasUiHandlers<VisitUiHandlers> {
        void setVisitList(List<VisitModel> models);

        void setHeaderText(String text);
    }


    @NameToken(NameTokens.VISIT)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<VisitPresenter> {
    }

    @Inject
    private DispatchAsync dispatch;

    @Inject
    VisitPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, TabsPresenter.SLOT_CONTENT);

        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

//        Window.alert("VisitPresenter.onReset");

        dispatch.execute(new GetVisitModelListAction(null), new AsyncCallback<GetVisitModelListResult>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("hyi");
            }

            @Override
            public void onSuccess(GetVisitModelListResult result) {
                getView().setVisitList(result.getModels());
            }
        });
    }

    @Override
    public void prepareFromRequest(PlaceRequest request) {
        super.prepareFromRequest(request);

        String id = request.getParameter(ParameterTokens.PATIENT_ID, null);

        getView().setHeaderText(id);

//        tabParamsHolder.copyFromPlaceRequest(request);

//        if (id != null) {
//            currentId = Long.parseLong(id);
//            loadDataQuery(currentId);
//        } else {
//            getProxy().manualReveal(this);
//        }

    }

    @Override
    protected void onBind() {
        super.onBind();

//        Window.alert("VisitPresenter.onBind");
    }
}
