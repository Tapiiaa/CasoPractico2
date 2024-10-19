package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.BiochemicalAttributes;
import com.example.casopractico2.model.BiologicalAttributes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BiochemicalDataProcessor {
    private List<BiochemicalAttributes> processedData = new ArrayList<>();

    public void processBiochemicalAtributtes(BiochemicalAttributes biochemicalAttributes) {
        System.out.println("Procesando atributos bioquimicos: " + biochemicalAttributes);
        System.out.println("Resistencia a la sequia: " + biochemicalAttributes.getDroughtResistance());
        System.out.println("Frecuencia de riego: " + biochemicalAttributes.getWateringFrequency());
        System.out.println("Zona climatica ideal: " + biochemicalAttributes.getIdealClimaticZone());
    }

    public List<BiochemicalAttributes> getProcessedData(){
        return processedData;
    }

}
