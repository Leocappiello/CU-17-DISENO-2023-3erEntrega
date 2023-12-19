package com.example.diseno.CU17.Entities;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "perfil")
@NoArgsConstructor
@Getter @Setter @AllArgsConstructor
public class Perfil {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String descripcion;
    @Column
    private String nombre;
    @OneToMany(mappedBy = "permiso_id")
    private List<Permiso> permisos;
}
