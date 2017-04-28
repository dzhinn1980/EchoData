package ru.dzhinn.echodata.gwt.shared.dto.visit;

import com.google.gwt.view.client.ProvidesKey;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by A.Dzhioev on 28.02.2017.
 */
public class VisitModel implements Serializable, ProvidesKey<VisitModel>{

    private Long id;
    private Date visitDate;

    public VisitModel() {
    }

    public VisitModel(Long id, Date visitDate) {
        this.id = id;
        this.visitDate = visitDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getVisitDate() {
        return visitDate;
    }

    public void setVisitDate(Date visitDate) {
        this.visitDate = visitDate;
    }

    @Override
    public Object getKey(VisitModel item) {
        return item.getId();
    }
}
