package com.example.casopractico2.model;

public class BiologicalAttributes {
    private String species;      // Especie de la planta
    private String leafType;     // Tipo de hoja
    private String flowerColor;  // Color de la flor
    private String growthHabit;  // Hábito de crecimiento

    public BiologicalAttributes(String species, String leafType, String flowerColor, String growthHabit) {
        this.species = species;
        this.leafType = leafType;
        this.flowerColor = flowerColor;
        this.growthHabit = growthHabit;
    }

    // Getters y Setters
    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getLeafType() {
        return leafType;
    }

    public void setLeafType(String leafType) {
        this.leafType = leafType;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public String getGrowthHabit() {
        return growthHabit;
    }

    public void setGrowthHabit(String growthHabit) {
        this.growthHabit = growthHabit;
    }

    // toString para mostrar los datos biológicos
    @Override
    public String toString() {
        return "BiologicalAttributes{" +
                "species='" + species + '\'' +
                ", leafType='" + leafType + '\'' +
                ", flowerColor='" + flowerColor + '\'' +
                ", growthHabit='" + growthHabit + '\'' +
                '}';
    }
}
