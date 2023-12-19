package com.example.diseno.CU17.Entities;

import java.util.ArrayList;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pregunta")
@AllArgsConstructor @Getter @Setter @NoArgsConstructor
public class Pregunta {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String pregunta;
    @OneToMany(mappedBy = "respuesta_id")
    private ArrayList<RespuestaPosible> respuesta;
}
