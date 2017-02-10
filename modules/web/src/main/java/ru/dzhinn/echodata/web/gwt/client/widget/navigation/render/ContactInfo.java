package ru.dzhinn.echodata.web.gwt.client.widget.navigation.render;

import java.util.Arrays;
import java.util.List;

/**
 * Created by A.Dzhioev on 08.02.2017.
 */
public class ContactInfo {
    String fullName;
    String address;

    private static final List<ContactInfo> contacts = Arrays.asList(
            new ContactInfo("fio1", "adr1"),
            new ContactInfo("fio2", "adr2"),
            new ContactInfo("fio3", "adr3"),
            new ContactInfo("fio4", "adr4"),
            new ContactInfo("fio5", "adr5"),
            new ContactInfo("fio6", "adr6"),
            new ContactInfo("fio7", "adr7"),
            new ContactInfo("fio8", "adr8"),
            new ContactInfo("fio9", "adr9"),
            new ContactInfo("fio11", "adr11"),
            new ContactInfo("fio12", "adr12"),
            new ContactInfo("fio13", "adr13"),
            new ContactInfo("fio14", "adr14"),
            new ContactInfo("fio15", "adr15"),
            new ContactInfo("fio16", "adr16"),
            new ContactInfo("fio17", "adr17"),
            new ContactInfo("fio18", "adr18"),
            new ContactInfo("fio19", "adr19")
    );

    public ContactInfo() {
    }

    public ContactInfo(String fullName, String address) {
        this.fullName = fullName;
        this.address = address;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static List<ContactInfo> getContacts() {
        return contacts;
    }
}
