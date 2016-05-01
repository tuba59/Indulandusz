package com.bme.aut.indulandusz.model;

import com.bme.aut.indulandusz.BuildConfig;
import com.orm.SugarRecord;

import java.util.ArrayList;

public class Stop extends SugarRecord {

    private String name;
    private String id;
    private ArrayList<Vehicle> vehicleList = new ArrayList<Vehicle>();

    public Stop(String name_, String id_, ArrayList<Vehicle> vl){
        name = name_;
        id = id_;
        if(BuildConfig.IS_MOCK){
            vehicleList.add(new Vehicle("bus", "8", "BKK_01"));
            vehicleList.add(new Vehicle("tram", "61", "BKK_02"));
            vehicleList.add(new Vehicle("tram", "17", "BKK_03"));
        }
        else
            vehicleList = vl;
    }

    public String getStopId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Vehicle> getVehicleList() {
        return vehicleList;
    }
}
