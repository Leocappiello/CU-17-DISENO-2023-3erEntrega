package com.example.diseno.CU17.Entities;

import java.time.LocalDateTime;
import java.util.List;

import com.example.diseno.CU17.Entities.state.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cambioestado")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class CambioEstado {
    @Id
    @GeneratedValue
    @Column
    private int id;

    @Column
    private LocalDateTime fechaHoraInicio;

    @ManyToOne
    @JoinColumn(name = "llamada_id")
    private State estado;

    @Column
    public boolean esEstadoInicial() {
        return true;
    }

    @Column
    public boolean esUltimoEstado() {
        return true;
    }
}
