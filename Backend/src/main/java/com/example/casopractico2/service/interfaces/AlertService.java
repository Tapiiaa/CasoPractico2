package com.example.casopractico2.service.interfaces;

public interface AlertService {
    void sendAlert(String message);
    void registerAlertListener();   // AlertListener listener -> Agregar luego
    void removeAlertListener();
}
