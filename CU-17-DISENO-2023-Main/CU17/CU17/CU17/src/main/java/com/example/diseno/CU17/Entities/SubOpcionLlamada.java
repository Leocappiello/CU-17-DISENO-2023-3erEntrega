package com.example.diseno.CU17.Entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "subopcionllamada")
@Entity
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class SubOpcionLlamada {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String nombre;
    @Column
    private int nroOrden;
    @ManyToOne
    @JoinColumn(name = "opcion_id")
    private OpcionLlamada opcionLlamada;
    @OneToMany(mappedBy = "validacion_id")
    private List<Validacion> validacionRequerida;

    public boolean esNro(int nro) {
        if (nro == this.nroOrden) {
            return true;
        }
        return false;
    }

    public List<String> buscarValidaciones() {
        List<String> mensajeValidaciones = new ArrayList<String>();

        for (Validacion validacion : validacionRequerida) {
            mensajeValidaciones.add(validacion.getAudioMensajeValidacion());
        }

        return mensajeValidaciones;
    }
}
