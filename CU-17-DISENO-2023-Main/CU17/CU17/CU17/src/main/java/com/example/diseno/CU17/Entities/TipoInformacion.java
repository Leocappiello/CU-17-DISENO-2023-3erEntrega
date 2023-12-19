package com.example.diseno.CU17.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "tipoinformacion")
@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class TipoInformacion {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String descripcion;
}
