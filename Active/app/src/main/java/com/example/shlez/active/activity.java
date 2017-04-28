package com.example.shlez.active;

import java.sql.Time;

/**
 * Created by hilas_000 on 4/28/2017.
 */

public class activity {
    public static int LastnumAct;

    private String name;
    private int numAct;
    private int cost;
    private Time time;
    private int maxPeople;

    public activity(String name, int numAct, int cost, Time time, int maxPeople) {
        this.name = name;
        this.numAct = numAct;
        this.cost = cost;
        this.time = time;
        this.maxPeople = maxPeople;
    }

    public activity() {
        this.name = null;
        this.numAct = LastnumAct+1;
        LastnumAct++;
        this.cost = 0;
        this.time = null;
        this.maxPeople =  0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumAct() {
        return numAct;
    }

    public void setNumAct(int numAct) {
        this.numAct = numAct;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(int maxPeople) {
        this.maxPeople = maxPeople;
    }

}
