package com.example.casopractico2.service.impl;

import com.example.casopractico2.service.interfaces.AlertListener;
import com.example.casopractico2.service.interfaces.AlertService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlertManager implements AlertService {
    private static final Logger logger = LoggerFactory.getLogger(AlertManager.class);
    private final List<AlertListener> listeners = new ArrayList<>();

    @Override
    public void sendAlert(String message) { //Enviamos la alerta a todos los listeners registrados y los mostramos mediante logs.
        logger.info("Enviando alerta: {}", message);
        for (AlertListener listener : listeners) {
            listener.alertReceived(message);
        }
        logger.debug("Todos los listeners han sido notificados con la alerta" + message);
    }

    @Override
    public void registerAlertListener(AlertListener alertListener) { //Registramos un listener para que reciba las alertas.
        logger.info("Registrando listener: {}", alertListener);
        listeners.add(alertListener);
        logger.debug("Listener registrado: {}", alertListener);
    }

    @Override
    public void removeAlertListener(AlertListener alertListener) { //Eliminamos un listener para que no reciba más alertas.
        logger.info("Eliminando listener: {}", alertListener);
        listeners.remove(alertListener);
        logger.debug("Listener eliminado: {}", alertListener);
    }

    private void NotifyListeners(String message) { //Notificamos a todos los listeners registrados.
        logger.info("Notificando a todos los listeners");
        for (AlertListener listener : listeners) {
            listener.alertReceived(message);
        }
        logger.debug("Todos los listeners han sido notificados");
    }

    public void clearListeners() { //Limpiamos la lista de listeners registrados.
        logger.info("Limpiando listeners");
        listeners.clear();
        logger.debug("Listeners limpiados");
    }

    public void logListeners() { //Mostramos los listeners registrados mediante logs.
        logger.info("Mostrando listeners registrados");
        for (AlertListener listener : listeners) {
            logger.info("Listener: {}", listener);
        }
        logger.debug("Todos los listeners han sido mostrados");
    }

    public void logListenersCount() { //Mostramos la cantidad de listeners registrados mediante logs.
        logger.info("Mostrando cantidad de listeners registrados: {}", listeners.size());
        logger.debug("Cantidad de listeners mostrada");
    }




}
