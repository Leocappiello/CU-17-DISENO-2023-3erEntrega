package com.example.diseno.CU17.Entities;

import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "encuesta")
@Entity
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Encuesta {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String descripcion;
    @Column
    private LocalDate fechaFinVigencia;
    @OneToMany(mappedBy = "pregunta_id")
    private ArrayList<Pregunta> pregunta;
}
