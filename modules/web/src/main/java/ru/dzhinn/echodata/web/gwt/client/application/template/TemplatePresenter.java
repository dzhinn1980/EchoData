package ru.dzhinn.echodata.web.gwt.client.application.template;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.presenter.slots.NestedSlot;
import com.gwtplatform.mvp.client.presenter.slots.SingleSlot;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.dzhinn.echodata.web.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.web.gwt.client.application.template.list.TemplateListPresenter;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;

public class TemplatePresenter extends Presenter<TemplatePresenter.MyView, TemplatePresenter.MyProxy> implements TemplateUiHandlers {
    interface MyView extends View, HasUiHandlers<TemplateUiHandlers> {
    }

    @NameToken(NameTokens.TEMPLATE)
    @ProxyCodeSplit
    interface MyProxy extends ProxyPlace<TemplatePresenter> {
    }

    public static final SingleSlot SLOT_TEMPLATE = new SingleSlot();

    @Inject
    TemplateListPresenter listPresenter;

    @Inject
    TemplatePresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().setUiHandlers(this);
    }

    @Override
    protected void onBind() {
        super.onBind();

        setInSlot(SLOT_TEMPLATE, listPresenter);
    }
}
