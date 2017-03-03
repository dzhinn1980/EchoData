package ru.dzhinn.echodata.web.gwt.client.gin;

import com.gwtplatform.dispatch.rpc.client.gin.RpcDispatchAsyncModule;
import com.gwtplatform.mvp.client.gin.AbstractPresenterModule;
import com.gwtplatform.mvp.client.gin.DefaultModule;
import ru.dzhinn.echodata.web.gwt.client.application.ApplicationModule;
import ru.dzhinn.echodata.web.gwt.client.place.NameTokens;

/**
 * Created by A.Dzhioev on 02.02.2017.
 */
public class ClientModule extends AbstractPresenterModule {
    @Override
    protected void configure() {
        install(new DefaultModule.Builder()
                .defaultPlace(NameTokens.HOME)
                .errorPlace(NameTokens.HOME)
                .unauthorizedPlace(NameTokens.HOME)
                .build());

        install(new RpcDispatchAsyncModule());

        install(new ApplicationModule());

        bind(ResourceLoader.class).asEagerSingleton();
    }
}
