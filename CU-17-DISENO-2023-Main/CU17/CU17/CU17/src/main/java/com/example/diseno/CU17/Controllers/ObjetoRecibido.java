package com.example.diseno.CU17.Controllers;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class ObjetoRecibido {
    private List<Boolean> correcto;
    private String descripcion;
}
