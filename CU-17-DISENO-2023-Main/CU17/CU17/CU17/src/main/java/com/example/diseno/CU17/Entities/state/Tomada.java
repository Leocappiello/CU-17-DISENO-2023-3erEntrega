package com.example.diseno.CU17.Entities.state;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor()
public class Tomada extends State{
    @Override
    public boolean esIniciada() {
        return false;
    }

    @Override
    public boolean esEnCurso() {
        return false;
    }

    @Override
    public boolean esTomada() {
        return true;
    }

    @Override
    public boolean esFinalizada() {
        return false;
    }

    public Finalizada finalizarLlamada() {
        return new Finalizada();
    }
}
