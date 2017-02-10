package ru.dzhinn.echodata.web.gwt.client.application.template.list;

import com.google.inject.Inject;
import com.google.web.bindery.event.shared.EventBus;
import com.gwtplatform.mvp.client.HasUiHandlers;
import com.gwtplatform.mvp.client.Presenter;
import com.gwtplatform.mvp.client.View;
import com.gwtplatform.mvp.client.annotations.NameToken;
import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;
import com.gwtplatform.mvp.client.proxy.Proxy;
import com.gwtplatform.mvp.client.proxy.ProxyPlace;
import ru.dzhinn.echodata.web.gwt.client.application.ApplicationPresenter;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;

public class TemplateListPresenter extends Presenter<TemplateListPresenter.MyView, TemplateListPresenter.MyProxy> implements TemplateListUiHandlers {
    interface MyView extends View, HasUiHandlers<TemplateListUiHandlers> {
    }

//    @NameToken(NameTokens.TEMPLATE_LIST)
    @ProxyCodeSplit
    interface MyProxy extends Proxy<TemplateListPresenter> {
    }

//    public static final NestedSlot SLOT_TEMPLATELIST = new NestedSlot();

    @Inject
    TemplateListPresenter(
            EventBus eventBus,
            MyView view,
            MyProxy proxy) {
        super(eventBus, view, proxy, ApplicationPresenter.SLOT_CONTENT);

        getView().setUiHandlers(this);
    }

}
