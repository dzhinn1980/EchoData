package ru.dzhinn.echodata.web.gwt.client.application.navigation;

import com.gwtplatform.mvp.client.UiHandlers;
import ru.dzhinn.echodata.web.gwt.shared.dto.patient.PatientModel;

interface NavigationUiHandlers extends UiHandlers {
    void onTemplateSelectionChange(String selected);

    void patientSelectionChange(PatientModel model);
}
