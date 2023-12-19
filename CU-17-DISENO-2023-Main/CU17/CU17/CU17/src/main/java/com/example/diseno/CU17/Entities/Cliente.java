package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cliente")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Cliente {
    @Id
    @GeneratedValue
    @Column
    private int dni;
    @Column
    private String  nombreCompleto;
    @Column
    private int nroCelular;
    @OneToMany(mappedBy = "informacion_id")
    private List<InformacionCliente> info;
    
    public boolean esCliente(int dni) {
        if (dni == this.dni) {
            return true;
        }
        return false;
    }

    public void esValidacion() {
        for (InformacionCliente informacionCliente : info) {
            informacionCliente.esValidacion(informacionCliente.getOpcionCorrecta());
        }
    }

    public Boolean esInformacionCorrecta(boolean validacion) {
        if (validacion) {
            return true;
        }
        return false;
    }

}
