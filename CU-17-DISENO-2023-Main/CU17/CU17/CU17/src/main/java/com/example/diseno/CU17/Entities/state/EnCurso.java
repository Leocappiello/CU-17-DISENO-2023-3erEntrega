package com.example.diseno.CU17.Entities.state;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor()
public class EnCurso extends State {
    @Override
    public boolean esIniciada() {
        return false;
    }

    @Override
    public boolean esEnCurso() {
        return true;
    }

    @Override
    public boolean esTomada() {
        return false;
    }

    @Override
    public boolean esFinalizada() {
        return false;
    }

    public Tomada tomarLlamada() {
        return new Tomada();
    }
}
