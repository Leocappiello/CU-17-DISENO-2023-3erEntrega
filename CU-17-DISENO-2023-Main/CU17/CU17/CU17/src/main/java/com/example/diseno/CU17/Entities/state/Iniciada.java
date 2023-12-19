package com.example.diseno.CU17.Entities.state;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor()
public class Iniciada extends State{
    @Override
    public boolean esIniciada() {
        return true;
    }

    @Override
    public boolean esEnCurso() {
        return false;
    }

    @Override
    public boolean esTomada() {
        return false;
    }

    @Override
    public boolean esFinalizada() {
        return false;
    }

    public EnCurso llamadaEnCurso() {
        return new EnCurso();
    }
}
