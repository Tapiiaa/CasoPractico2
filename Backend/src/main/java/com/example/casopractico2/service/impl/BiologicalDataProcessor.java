package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.BiologicalAttributes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BiologicalDataProcessor {
    private List<BiologicalAttributes> processedData = new ArrayList<>();

    public void processBiologicalAtributtes(BiologicalAttributes biologicalAttributes) {
        System.out.println("Procesando atributos biológicos: " + biologicalAttributes);
        System.out.println("Especie: " + biologicalAttributes.getSpecies());
        System.out.println("Tipo de hoja: " + biologicalAttributes.getLeafType());
        System.out.println("Color de la flor: " + biologicalAttributes.getFlowerColor());
        System.out.println("Habito de crecimiento: " + biologicalAttributes.getGrowthHabit());
    }

    public List<BiologicalAttributes> getProcessedData(){
        return processedData;
    }

}
