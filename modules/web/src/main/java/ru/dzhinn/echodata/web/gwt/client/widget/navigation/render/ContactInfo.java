package ru.dzhinn.echodata.web.gwt.client.widget.navigation.render;

/**
 * Created by A.Dzhioev on 08.02.2017.
 */
public class ContactInfo {
    String fullName;
    String address;

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
}
