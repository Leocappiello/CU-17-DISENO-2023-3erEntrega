package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "categoriallamada")
@Entity
@Setter @Getter @NoArgsConstructor
public class CategoriaLlamada {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String audioMensajeOpciones;
    @Column
    private String mensajeOpciones;
    @Column
    private String nombre;
    @Column
    private int nroOrden;
    @OneToMany(mappedBy = "opcion_id")
    private List<OpcionLlamada> opciones;

    public CategoriaLlamada(String audio, String mensaje, String nombre, int nroOrden) {
        this.audioMensajeOpciones = audio;
        this.mensajeOpciones = mensaje;
        this.nombre = nombre;
        this.nroOrden = nroOrden;
    }

    public String getDescripcionCompletaCategoriaYOpcion(SubOpcionLlamada subopcionSeleccionada, OpcionLlamada opcionSeleccionada) {
        List<OpcionLlamada> opcionesCatSeleccionada = this.getOpciones();
        
        for (OpcionLlamada opcion : opcionesCatSeleccionada) {
            if (opcion.getNombre() == opcionSeleccionada.getNombre()) {
                String subopcion= opcion.getDescripcionConSubopcion(subopcionSeleccionada);
                return opcion.getNombre() + " - "+ subopcion;
            }
        }

        return "";
    }

    public List<String> buscarValidaciones(OpcionLlamada opcionLlamada, SubOpcionLlamada subopcion) {
        List<String> opciones = opcionLlamada.buscarValidaciones(subopcion);
        return opciones;
    }

    public Boolean esNroCat(int nroOrden) {
        if (nroOrden == this.nroOrden) {
            return true;
        }
        return false;
    }
}
