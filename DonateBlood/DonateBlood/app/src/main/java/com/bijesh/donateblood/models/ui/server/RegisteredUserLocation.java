package com.bijesh.donateblood.models.ui.server;

/**
 * Created by Bijesh on 1/14/2018.
 */

public class RegisteredUserLocation {
    private String city;
    private Location location;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
