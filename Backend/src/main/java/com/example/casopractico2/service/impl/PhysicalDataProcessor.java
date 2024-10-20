package com.example.casopractico2.service.impl;

import com.example.casopractico2.model.PhysicalAttributes;
import jakarta.annotation.PostConstruct;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class PhysicalDataProcessor {
    private List<PhysicalAttributes> processedData = new ArrayList<>();
    private static final Logger logger = Logger.getLogger(PhysicalDataProcessor.class.getName());
    @PostConstruct
    public void loadPhysicalDataFromCSV() {
        logger.info("Intentando cargar el archivo CSV desde /app/data/biological_data.csv");
        try {
            FileInputStream inputStream = new FileInputStream("/app/data/biological_data.csv");
            logger.info("Archivo CSV encontrado. Comenzando la lectura...");

            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                // Leer la cabecera
                br.readLine();
                while ((line = br.readLine()) != null) {
                    logger.info("Leyendo línea: " + line);
                    String[] values = line.split(",");
                    if (values.length >= 4) {
                        // Extraer los atributos necesarios del CSV
                        double height = Double.parseDouble(values[2].trim()); // Height (m) está en la tercera columna
                        String locationZone = values[3].trim();              // Location Zone está en la cuarta columna
                        PhysicalAttributes physicalAttributes = new PhysicalAttributes(height, locationZone);
                        processedData.add(physicalAttributes);
                        logger.info("Añadido: " + physicalAttributes.getHeight() + ", " + physicalAttributes.getLocationZone());
                    } else {
                        logger.warning("Línea mal formada: " + line);
                    }
                }
                logger.info("Datos físicos cargados con éxito. Número de muestras: " + processedData.size());
            }
        } catch (Exception e) {
            logger.severe("Error al leer el archivo CSV: " + e.getMessage());
        }
    }


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
