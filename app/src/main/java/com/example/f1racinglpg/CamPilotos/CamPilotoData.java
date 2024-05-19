package com.example.f1racinglpg.CamPilotos;

public class CamPilotoData {

    private String position;
    private String points;
    private String wins;
    private String name;
    private String constructor;
    private String code;
    private String Birth;
    private String nationality;
    private String permanentNumber;







    public String getPermanentNumber() {
        return permanentNumber;
    }

    public void setPermanentNumber(String permanentNumber) {
        this.permanentNumber = permanentNumber;
    }

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


    public void setConstructor(String constructor) {
        this.constructor = constructor;
    }
    public String getConstructor(){return constructor;}
    public void setWins(String wins) {
        this.wins = wins;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBirth() {
        return Birth;
    }

    public void setBirth(String birth) {
        Birth = birth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public CamPilotoData(String position, String points, String wins, String name,String constructor, String code, String birth, String nationality,String permanentNumber) {
        this.position = position;
        this.points = points;
        this.wins = wins;
        this.name = name;
        this.constructor=constructor;
        this.code = code;
        Birth = birth;
        this.nationality = nationality;
        this.permanentNumber=permanentNumber;
    }


}
