package ru.dzhinn.echodata.gwt.client.application.navigation;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.dzhinn.echodata.gwt.client.application.navigation.model.TemplateTreeModel;
import ru.dzhinn.echodata.gwt.shared.dto.patient.PatientModel;

interface NavigationUiHandlers extends UiHandlers {
    void onTemplateSelectionChange(TemplateTreeModel model);

    void patientSelectionChange(PatientModel model);
}
