package com.example.diseno.CU17.Entities.observer;

import com.example.diseno.CU17.Entities.Llamada;

import java.util.List;

public class NotificadorLlamada {
    private List<Llamada> llamadas;

    public void subscribe(Llamada llamada) {
        llamadas.add(llamada);
    }

    public void unsubscribe(Llamada llamada) {
        llamadas.remove(llamada);
    }

    public void notifyLlamada() {
        for(Llamada llamada: llamadas) {
            // llamada api
        }
    }
}
