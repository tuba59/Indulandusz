package com.bme.aut.indulandusz.model;

public class Vehicle {

    private String type;
    private String name;
    private String id;
    private String departureTimes;

    public Vehicle(String type_, String name_, String id_, String departureTimes_){
        type = type_;
        name = name_;
        id = id_;
        departureTimes = departureTimes_;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDepartureTimes() {
        return departureTimes;
    }
}
