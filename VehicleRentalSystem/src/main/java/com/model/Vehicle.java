package com.model;

public class Vehicle {

    // deploy attributes
    private int id;
    private String vehicle_number;
    private String model;
    private String color;
    private String r_price;

    public Vehicle(){

    }

    // overloaded constructor
    public Vehicle(String vehicle_number, String model, String color, String r_price) {
        this.vehicle_number = vehicle_number;
        this.model = model;
        this.color = color;
        this.r_price = r_price;
    }

    // setters and getters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        this.vehicle_number = vehicle_number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getR_Price() {
        return r_price;
    }

    public void setR_Price(String r_price) {
        this.r_price = r_price;
    }
}
