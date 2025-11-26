package com.sujal.weather_application.model;
public class AQList{
    private AQMain main;
    private Components components;


    public AQMain getMain() {
        return main;
    }

    public void setMain(AQMain main) {
        this.main = main;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}
