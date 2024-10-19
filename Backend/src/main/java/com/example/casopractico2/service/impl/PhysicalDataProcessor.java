package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.PhysicalAttributes;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PhysicalDataProcessor {
    private List<PhysicalAttributes> processedData = new ArrayList<>();

    public void processPhysicalAtributtes(PhysicalAttributes physicalAttributes){
        System.out.println("Procesando atributos físicos: ");
        System.out.println("Altura: " + physicalAttributes.getHeight() + "metros");
        System.out.println("Zona geográfica: " + physicalAttributes.getLocationZone());

        processedData.add(physicalAttributes);
    }

    public List<PhysicalAttributes> getProcessedData(){
        return processedData;
    }
}
