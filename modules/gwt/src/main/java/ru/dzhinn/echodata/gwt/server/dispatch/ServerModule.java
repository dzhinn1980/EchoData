package ru.dzhinn.echodata.gwt.server.dispatch;

import com.gwtplatform.dispatch.rpc.server.actionvalidator.ActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.HandlerModule;
import com.gwtplatform.dispatch.rpc.server.spring.actionvalidator.DefaultActionValidator;
import com.gwtplatform.dispatch.rpc.server.spring.configuration.DefaultModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.dzhinn.echodata.gwt.server.dispatch.template.GetChildTemplateListActionHandler;
import ru.dzhinn.echodata.gwt.server.dispatch.template.GetTemplateModelListActionHandler;
import ru.dzhinn.echodata.gwt.shared.dispatch.patient.GetPatientListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetChildTemplateListAction;
import ru.dzhinn.echodata.gwt.shared.dispatch.visit.GetVisitModelListAction;
import ru.dzhinn.echodata.gwt.server.dispatch.patient.GetPatientListActionHandler;
import ru.dzhinn.echodata.gwt.server.dispatch.visit.GetVisitModelListActionHandler;
import ru.dzhinn.echodata.gwt.shared.dispatch.template.GetTemplateModelListAction;

@Configuration
@Import(value = DefaultModule.class)
public class ServerModule extends HandlerModule {

    public ServerModule() {
    }

    @Bean
    public ActionValidator getDefaultActionValidator() {
        return new DefaultActionValidator();
    }

    @Override
    protected void configureHandlers() {
        bindHandler(GetPatientListAction.class, GetPatientListActionHandler.class);

        bindHandler(GetTemplateModelListAction.class, GetTemplateModelListActionHandler.class);
        bindHandler(GetChildTemplateListAction.class, GetChildTemplateListActionHandler.class);

        bindHandler(GetVisitModelListAction.class, GetVisitModelListActionHandler.class);


    }
}
