package com.example.flex;

public class Workout {
    private String wName;
    private String wDesc;

    public Workout() {
    }

    public Workout(String wName, String wDesc) {
        this.wName = wName;
        this.wDesc = wDesc;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getwDesc() {
        return wDesc;
    }

    public void setwDesc(String wDesc) {
        this.wDesc = wDesc;
    }
}
