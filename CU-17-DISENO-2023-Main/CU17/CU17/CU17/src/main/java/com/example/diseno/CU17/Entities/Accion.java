package com.example.diseno.CU17.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "accion")
@Entity
@NoArgsConstructor @AllArgsConstructor @Setter @Getter
public class Accion {
    @Id
    @GeneratedValue
    @Column
    private Integer id;
    @Column
    private String descripcion;
}
