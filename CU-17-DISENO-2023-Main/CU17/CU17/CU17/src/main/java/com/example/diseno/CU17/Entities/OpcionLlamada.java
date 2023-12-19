package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "opcionllamada")
@Entity
@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class OpcionLlamada {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String audioMensajeSubopciones;
    @Column
    private String mensajeSubopciones;
    @Column
    private String nombre;
    @Column
    private int nroOrden;
    @OneToMany(mappedBy = "validacion_id")
    private List<Validacion> validacionesRequeridas;
    @ManyToOne
    private CategoriaLlamada categoriaLlamada;
    @OneToMany(mappedBy = "subOpcion_id")
    private List<SubOpcionLlamada> subOpcionLlamada;

    public OpcionLlamada(String audioMensajeSubopciones, String mensajeSubopciones, String nombre, int nroOrden, List<Validacion> validacionesRequeridas, CategoriaLlamada  categoriaLlamada) {
        this.audioMensajeSubopciones = audioMensajeSubopciones;
        this.mensajeSubopciones = mensajeSubopciones;
        this.nombre = nombre;
        this.nroOrden = nroOrden;
        this.validacionesRequeridas = validacionesRequeridas;
        this.categoriaLlamada = categoriaLlamada;
    }

    public List<String> buscarValidaciones(SubOpcionLlamada subOpcionLlamada) {
        return subOpcionLlamada.buscarValidaciones();
    }

    public String getDescripcionConSubopcion(SubOpcionLlamada subopcionSeleccionada) {
        /* return this.nombre; // 12. */
        List<SubOpcionLlamada> subOpciones = this.getSubOpcionLlamada();

        for (SubOpcionLlamada  subopcion: subOpciones) {
            if (subopcion.getNombre() == subopcionSeleccionada.getNombre()) {
                return subopcionSeleccionada.getNombre(); // 12.
            }
        }

        return null;
    }
}
