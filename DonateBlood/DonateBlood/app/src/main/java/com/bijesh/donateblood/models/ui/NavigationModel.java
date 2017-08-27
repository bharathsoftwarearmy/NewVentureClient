package com.bijesh.donateblood.models.ui;

/**
 * Created by Bijesh on 8/27/2017.
 */

public class NavigationModel {
    public int icon;
    public String name;

    // Constructor.
    public NavigationModel(int icon, String name) {

        this.icon = icon;
        this.name = name;
    }

    public NavigationModel(String name){
        this.name = name;
    }
}
