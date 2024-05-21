package com.example.f1racinglpg.CamConstructores;

public class CamConsData {

    private String position;
    private String points;
    private String wins;
    private String name;
    private String nationality;





    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getWins() {
        return wins;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CamConsData(String position, String points, String wins, String name ,String nationality) {
        this.position = position;
        this.points = points;
        this.wins = wins;
        this.name = name;
        this.nationality = nationality;
    }
}
