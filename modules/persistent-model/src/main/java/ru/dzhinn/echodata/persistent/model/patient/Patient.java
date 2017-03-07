package ru.dzhinn.echodata.persistent.model.patient;

import java.util.Date;

/**
 * Created by A.Dzhioev on 06.03.2017.
 */
public class Patient {

    Long id;
    String fullName;
    Date dateOfBirth;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
