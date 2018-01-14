package com.bijesh.donateblood.models.ui.server;

/**
 * Created by Bijesh on 1/14/2018.
 */

public class RegisteredUser {

    private String name;
    private String gender;
    private ContactDetails contactDetails;
    private RegisteredUserLocation registeredUserLocation;

    public RegisteredUserLocation getRegisteredUserLocation() {
        return registeredUserLocation;
    }

    public void setRegisteredUserLocation(RegisteredUserLocation registeredUserLocation) {
        this.registeredUserLocation = registeredUserLocation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(ContactDetails contactDetails) {
        this.contactDetails = contactDetails;
    }
}
