package com.example.f1racinglpg.Circuitos;

public class CircuitoData {

    private String circuitUrl;

    public String getCircuitUrl() {
        return circuitUrl;
    }

    public void setCircuitUrl(String circuitUrl) {
        this.circuitUrl = circuitUrl;
    }

    private String circuitName;
    private String latitud;
    private String longitud;
    private String locality;
    private String country;


    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCircuitName() {
        return circuitName;
    }

    public String getLatitud() {
        return latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public String getLocality() {
        return locality;
    }

    public String getCountry() {
        return country;
    }

    public CircuitoData(String circuitUrl,String circuitName, String latitud, String longitud, String locality, String country) {
        this.circuitUrl =circuitUrl;
        this.circuitName = circuitName;
        this.latitud = latitud;
        this.longitud = longitud;
        this.locality = locality;
        this.country = country;
    }
}
