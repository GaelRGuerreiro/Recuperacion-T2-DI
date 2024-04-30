package com.example.f1racinglpg;


public class CorredorData {

    private String driverName;
    private String constructorName;
    private String position;
    private String time;
    private String points;



    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public void setConstructorName(String constructorName) {
        this.constructorName = constructorName;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPoints(String points) {
        this.points = points;
    }


    public String getDriverName() {
        return driverName;
    }

    public String getConstructorName() {
        return constructorName;
    }

    public String getPosition() {
        return position;
    }

    public String getTime() {
        return time;
    }

    public String getPoints() {
        return points;
    }

    public CorredorData(String driverName, String constructorName, String position, String time, String points) {
        this.driverName = driverName;
        this.constructorName = constructorName;
        this.position = position;
        this.time = time;
        this.points = points;
    }


}