package com.bijesh.donateblood.models.ui;

/**
 * Created by bijesh on 6/3/2015.
 */
public class Installation {

    private String uniqueId;
    private String time;
    private String timezone;

    public String getUniqueId() {
        return uniqueId;
    }
    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
    public String getTimezone() {
        return timezone;
    }
    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

}
