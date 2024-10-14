package com.example.casopractico2.model;

public class BiologicalSample {
    private int sampleId;
    private String species;
    private double weight;
    private double height;
    private int age;
    private String gender;
    private String location;

    // Getters y Setters
    public int getSampleId() {
        return sampleId;
    }

    public void setSampleId(int sampleId) {
        this.sampleId = sampleId;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    // toString() para depurar y mostrar los datos
    @Override
    public String toString() {
        return "BiologicalSample{" +
                "sampleId=" + sampleId +
                ", species='" + species + '\'' +
                ", weight=" + weight +
                ", height=" + height +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
