package com.example.diseno.CU17.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "informacioncliente")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class InformacionCliente {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String datoAValidar;
    @OneToOne
    private OpcionValidacion opcionCorrecta;
    @OneToOne
    private TipoInformacion tipoInformacion;
    @OneToOne
    private Validacion validacion;

    public boolean esInformacionCorrecta(String validacion) {
        if (validacion == opcionCorrecta.toString()) {
            return true;
        }
        return false;
    }

    public boolean esValidacion(OpcionValidacion validacion) {
        return true;
    }
}
