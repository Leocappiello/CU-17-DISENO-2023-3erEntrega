package com.example.diseno.CU17.Entities.state;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.stereotype.Component;

//@Component
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_estado")
public abstract class State {
    //
    @Id
    @GeneratedValue
    private int id;
    public abstract boolean esIniciada();
    public abstract boolean esEnCurso();
    public abstract boolean esTomada();
    public abstract boolean esFinalizada();
}
