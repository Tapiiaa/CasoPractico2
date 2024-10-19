package com.example.casopractico2.model;

public class BiochemicalAttributes {
    private String droughtResistance;      // Resistencia a la sequía
    private int wateringFrequency;         // Frecuencia de riego
    private String idealClimaticZone;      // Zona climática ideal

    public BiochemicalAttributes(String droughtResistance, int wateringFrequency, String idealClimaticZone) {
        this.droughtResistance = droughtResistance;
        this.wateringFrequency = wateringFrequency;
        this.idealClimaticZone = idealClimaticZone;
    }

    // Getters y Setters
    public String getDroughtResistance() {
        return droughtResistance;
    }

    public void setDroughtResistance(String droughtResistance) {
        this.droughtResistance = droughtResistance;
    }

    public int getWateringFrequency() {
        return wateringFrequency;
    }

    public void setWateringFrequency(int wateringFrequency) {
        this.wateringFrequency = wateringFrequency;
    }

    public String getIdealClimaticZone() {
        return idealClimaticZone;
    }

    public void setIdealClimaticZone(String idealClimaticZone) {
        this.idealClimaticZone = idealClimaticZone;
    }

    // toString para mostrar los datos bioquímicos
    @Override
    public String toString() {
        return "BiochemicalAttributes{" +
                "droughtResistance='" + droughtResistance + '\'' +
                ", wateringFrequency=" + wateringFrequency +
                ", idealClimaticZone='" + idealClimaticZone + '\'' +
                '}';
    }
}
