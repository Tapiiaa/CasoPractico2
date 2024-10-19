package com.example.casopractico2.service.interfaces;

public interface AlertService {
    void sendAlert(String message);
    void registerAlertListener(AlertListener alertListener);
    void removeAlertListener(AlertListener alertListener);
}
