package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.BiologicalAttributes;

public class BiologicalDataProcessor {

    public void processBiologicalAtributtes(BiologicalAttributes biologicalAttributes) {
        System.out.println("Procesando atributos biológicos: " + biologicalAttributes);
        System.out.println("Especie: " + biologicalAttributes.getSpecies());
        System.out.println("Tipo de hoja: " + biologicalAttributes.getLeafType());
        System.out.println("Color de la flor: " + biologicalAttributes.getFlowerColor());
        System.out.println("Habito de crecimiento: " + biologicalAttributes.getGrowthHabit());
    }
}
