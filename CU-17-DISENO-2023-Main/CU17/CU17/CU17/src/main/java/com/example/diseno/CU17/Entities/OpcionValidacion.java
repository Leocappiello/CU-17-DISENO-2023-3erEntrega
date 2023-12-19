package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "opcionvalidacion")
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class OpcionValidacion {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private boolean correcta;
    @Column
    private String descripcion;
    @OneToMany(mappedBy = "validacion_id")
    private List<Validacion> validacion;

    public OpcionValidacion(boolean correcta, String descripcion) {
        this.correcta = correcta;
        this.descripcion = descripcion;
    }
}
