package com.example.diseno.CU17.Controllers;

import java.util.List;

import com.example.diseno.CU17.Entities.CategoriaLlamada;
import com.example.diseno.CU17.Entities.Llamada;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor
class Contenedor {
    private String descripcion;
    private Llamada llamada;
    private CategoriaLlamada categoria;
    private List<String> validaciones;
}