package com.bme.aut.indulandusz.Interactor.event;

import com.bme.aut.indulandusz.model.Stop;

import java.util.List;

public class GetStopsEvent {
    private int code;
    private List<Stop> stops;
    private Throwable throwable;

    //<editor-fold desc="Constructors|Getters|Setters">

    public GetStopsEvent() {
    }

    public GetStopsEvent(int code, List<Stop> stops, Throwable throwable) {
        this.code = code;
        this.stops = stops;
        this.throwable = throwable;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public void setStops(List<Stop> stops) {
        this.stops = stops;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }

    //</editor-fold>
}
