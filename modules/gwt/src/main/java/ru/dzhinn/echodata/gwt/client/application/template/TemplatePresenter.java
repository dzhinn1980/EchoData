package ru.dzhinn.echodata.gwt.client.application.template;

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
import ru.dzhinn.echodata.gwt.client.application.test.TabsPresenter;
import ru.dzhinn.echodata.gwt.client.place.NameTokens;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetTemplateModelListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetTemplateModelListResult;
import ru.dzhinn.echodata.gwt.shared.dto.template.TemplateModel;

import java.util.List;

public class TemplatePresenter extends Presenter<TemplatePresenter.MyView, TemplatePresenter.MyProxy> implements TemplateUiHandlers {
    interface MyView extends View, HasUiHandlers<TemplateUiHandlers> {
        void setTemplateList(List<TemplateModel> models);
    }

    @NameToken(NameTokens.TEMPLATE)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<TemplatePresenter> {
    }

    @Inject
    private DispatchAsync dispatch;

    @Inject
    TemplatePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, TabsPresenter.SLOT_CONTENT);

        getView().setUiHandlers(this);
    }

    @Override
    protected void onReset() {
        super.onReset();

        dispatch.execute(new GetTemplateModelListAction(null), new AsyncCallback<GetTemplateModelListResult>() {
            @Override
            public void onFailure(Throwable caught) {
                Window.alert("hyi");
            }

            @Override
            public void onSuccess(GetTemplateModelListResult result) {
                getView().setTemplateList(result.getModels());
            }
        });
    }
}
