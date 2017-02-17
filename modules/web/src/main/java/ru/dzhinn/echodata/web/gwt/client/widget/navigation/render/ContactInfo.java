package ru.dzhinn.echodata.web.gwt.client.widget.navigation.render;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Dzhioev on 08.02.2017.
 */
public class ContactInfo {
    String fullName;
    String dateOfBirth;

    private static final List<ContactInfo> contacts = Arrays.asList(
            new ContactInfo("fio1", "19.11.1981"),
            new ContactInfo("fio2", "19.11.1982"),
            new ContactInfo("fio3", "19.11.1983"),
            new ContactInfo("fio4", "19.11.1984"),
            new ContactInfo("fio5", "19.11.1985"),
            new ContactInfo("fio6", "19.11.1986"),
            new ContactInfo("fio7", "19.11.1987"),
            new ContactInfo("fio8", "19.11.1988"),
            new ContactInfo("fio9", "19.11.1989"),
            new ContactInfo("fio11", "19.11.1981"),
            new ContactInfo("fio12", "19.11.1982"),
            new ContactInfo("fio13", "19.11.1983"),
            new ContactInfo("fio14", "19.11.1984"),
            new ContactInfo("fio15", "19.11.1985"),
            new ContactInfo("fio16", "19.11.1986"),
            new ContactInfo("fio17", "19.11.1987"),
            new ContactInfo("fio18", "19.11.1988"),
            new ContactInfo("fio19", "19.11.1989")
    );

    public ContactInfo() {
    }

    public ContactInfo(String fullName, String dateOfBirth) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
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

    public static List<ContactInfo> getContacts() {
        return contacts;
    }
}
