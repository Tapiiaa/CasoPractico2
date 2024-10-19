package com.example.casopractico2.model;

public class PhysicalAttributes {
    private double height;       // Altura de la planta
    private String locationZone; // Zona geográfica

    public PhysicalAttributes(double height, String locationZone) {
        this.height = height;
        this.locationZone = locationZone;
    }

    // Getters y Setters
    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getLocationZone() {
        return locationZone;
    }

    public void setLocationZone(String locationZone) {
        this.locationZone = locationZone;
    }

    // toString para mostrar los datos físicos
    @Override
    public String toString() {
        return "PhysicalAttributes{" +
                "height=" + height +
                ", locationZone='" + locationZone + '\'' +
                '}';
    }
}
