package com.example.diseno.CU17.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "respuestacliente")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RespuestaDeCliente {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private LocalDate fechaEncuesta;
    @OneToOne
    private RespuestaPosible respuestaSeleccionada;
}
