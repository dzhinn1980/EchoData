package ru.dzhinn.echodata.web.gwt.shared.dto.patient;

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

//    private static final List<PatientModel> contacts = Arrays.asList(
//            new PatientModel("fio1", "19.11.1981"),
//            new PatientModel("fio2", "19.11.1982"),
//            new PatientModel("fio3", "19.11.1983"),
//            new PatientModel("fio4", "19.11.1984"),
//            new PatientModel("fio5", "19.11.1985"),
//            new PatientModel("fio6", "19.11.1986"),
//            new PatientModel("fio7", "19.11.1987"),
//            new PatientModel("fio8", "19.11.1988"),
//            new PatientModel("fio9", "19.11.1989"),
//            new PatientModel("fio11", "19.11.1981"),
//            new PatientModel("fio12", "19.11.1982"),
//            new PatientModel("fio13", "19.11.1983"),
//            new PatientModel("fio14", "19.11.1984"),
//            new PatientModel("fio15", "19.11.1985"),
//            new PatientModel("fio16", "19.11.1986"),
//            new PatientModel("fio17", "19.11.1987"),
//            new PatientModel("fio18", "19.11.1988"),
//            new PatientModel("fio19", "19.11.1989")
//    );

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

//    public static List<PatientModel> getContacts() {
//        return contacts;
//    }
//
//    @Override
//    public Object getKey(PatientModel item) {
//        return item.getId();
//    }
}
