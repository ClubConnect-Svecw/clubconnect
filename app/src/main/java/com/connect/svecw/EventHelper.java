package com.connect.svecw;

import co.uk.rushorm.core.RushObject;


public class EventHelper extends RushObject {

    private String name,description,club1;
    private String date;

    public EventHelper(){}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getClub(){return club1;}
    public void setClub(String club1){this.club1 = club1;}


}

