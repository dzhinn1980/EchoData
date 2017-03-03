package ru.dzhinn.echodata.web.gwt.shared.dispatch.visit;

import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class GetVisitModelListAction extends UnsecuredActionImpl<GetVisitModelListResult> {

    private Long patientId;

    GetVisitModelListAction() {
    }

    public GetVisitModelListAction(Long patientId) {
        this.patientId = patientId;
    }

    public Long getPatientId() {
        return patientId;
    }
}
