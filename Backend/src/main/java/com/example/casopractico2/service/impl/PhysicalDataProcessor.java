package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.PhysicalAttributes;

public class PhysicalDataProcessor {
    public void processPhysicalAtributtes(PhysicalAttributes physicalAttributes){
        System.out.println("Procesando atributos físicos: ");
        System.out.println("Altura: " + physicalAttributes.getHeight() + "metros");
        System.out.println("Zona geográfica: " + physicalAttributes.getLocationZone());
    }
}
