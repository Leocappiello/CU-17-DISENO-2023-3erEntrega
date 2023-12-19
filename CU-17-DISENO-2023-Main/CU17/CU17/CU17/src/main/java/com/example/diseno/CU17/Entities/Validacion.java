package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "validacion")
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Validacion {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String audioMensajeValidacion;
    @Column
    private String nombre;
    @OneToOne
    private TipoInformacion tipo;
    @OneToMany(mappedBy = "opcion_id")
    private List<OpcionValidacion> opcionesValidacion;

    public List<OpcionValidacion> mostrarDatosLlamadaYValidacionesRequeridas(){
        return this.opcionesValidacion;
    }
}
