package com.example.diseno.CU17.Entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "usuario")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Usuario {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private boolean activo;
    @Column
    private LocalDate fechaAlta;
    @Column
    private String nombreUsuario;
    @Column
    private String password;
    @OneToOne
    private Perfil perfil;
}
