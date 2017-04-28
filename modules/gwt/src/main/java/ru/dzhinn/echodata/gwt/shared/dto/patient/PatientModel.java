package ru.dzhinn.echodata.gwt.shared.dto.patient;

import com.google.gwt.view.client.ProvidesKey;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Dzhioev on 08.02.2017.
 */
public class PatientModel implements Serializable{

    Long id;
    String fullName;
    String dateOfBirth;


    public PatientModel() {
    }

    public PatientModel(Long id, String fullName, String dateOfBirth) {
        this.id = id;
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
    }

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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

}
