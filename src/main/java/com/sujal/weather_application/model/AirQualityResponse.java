package com.sujal.weather_application.model;
import  com.sujal.weather_application.model.AQList;
import java.util.List;

public class AirQualityResponse {
    private List<AQList> list;

    public List<AQList> getList() {
        return list;
    }

    public void setList(List<AQList> list) {
        this.list = list;
    }
}
