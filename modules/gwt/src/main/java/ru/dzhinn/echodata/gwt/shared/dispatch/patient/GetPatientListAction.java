package ru.dzhinn.echodata.gwt.shared.dispatch.patient;

import com.gwtplatform.dispatch.rpc.shared.ActionImpl;
import com.gwtplatform.dispatch.rpc.shared.UnsecuredActionImpl;

/**
 * Created by A.Dzhioev on 22.02.2017.
 */
public class GetPatientListAction extends UnsecuredActionImpl<GetPatientListResult> {

    private Long userId;

    public GetPatientListAction() {
    }

    public GetPatientListAction(Long userId) {
        this.userId = userId;
    }

    public Long getUserId() {
        return userId;
    }
}
