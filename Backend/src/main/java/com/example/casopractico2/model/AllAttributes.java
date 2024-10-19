package com.example.casopractico2.model;

public class AllAttributes {
    private PhysicalAttributes physicalAttributes;
    private BiologicalAttributes biologicalAttributes;
    private BiochemicalAttributes biochemicalAttributes;

    public AllAttributes(PhysicalAttributes physicalAttributes, BiologicalAttributes biologicalAttributes, BiochemicalAttributes biochemicalAttributes) {
        this.physicalAttributes = physicalAttributes;
        this.biologicalAttributes = biologicalAttributes;
        this.biochemicalAttributes = biochemicalAttributes;
    }

    // Getters y Setters
    public PhysicalAttributes getPhysicalAttributes() {
        return physicalAttributes;
    }

    public void setPhysicalAttributes(PhysicalAttributes physicalAttributes) {
        this.physicalAttributes = physicalAttributes;
    }

    public BiologicalAttributes getBiologicalAttributes() {
        return biologicalAttributes;
    }

    public void setBiologicalAttributes(BiologicalAttributes biologicalAttributes) {
        this.biologicalAttributes = biologicalAttributes;
    }

    public BiochemicalAttributes getBiochemicalAttributes() {
        return biochemicalAttributes;
    }

    public void setBiochemicalAttributes(BiochemicalAttributes biochemicalAttributes) {
        this.biochemicalAttributes = biochemicalAttributes;
    }

    // toString para mostrar todos los datos juntos
    @Override
    public String toString() {
        return "CompleteSample{" +
                "physicalAttributes=" + physicalAttributes +
                ", biologicalAttributes=" + biologicalAttributes +
                ", biochemicalAttributes=" + biochemicalAttributes +
                '}';
    }
}
