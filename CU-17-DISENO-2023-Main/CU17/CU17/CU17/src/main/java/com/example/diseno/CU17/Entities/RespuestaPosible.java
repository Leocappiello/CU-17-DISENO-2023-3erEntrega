package com.example.diseno.CU17.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "respuestaposible")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RespuestaPosible {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String descripcion;
    @Column
    private String valor;
}
