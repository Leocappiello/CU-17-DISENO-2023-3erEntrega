package com.example.diseno.CU17.Entities;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import com.example.diseno.CU17.Entities.state.Finalizada;
import com.example.diseno.CU17.Entities.state.State;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor @Getter @Setter
@Table(name = "llamada")
public class Llamada {
    @Id
    @GeneratedValue
    @Column
    private int id;
    @Column
    private String descripcionOperador;
    @Column
    private String detalleAccionRequerida;
    @Column
    private String duracion;
    @Column
    private String encuestaEnviada;
    @Column
    private String observacionAuditor;
    @OneToOne
    private OpcionLlamada opcionSeleccionada;
    @OneToOne
    private SubOpcionLlamada subOpcionLlamada;
    @OneToMany(mappedBy = "cambioEstado_id")
    private List<CambioEstado> cambioEstado;
//    @Enumerated(EnumType.STRING)
//    private State estadoActual;
    @OneToOne
    private Cliente cliente;
    @OneToOne
    private RespuestaDeCliente respuestasDeEncuesta;
    @OneToOne
    private Usuario auditor;
    @OneToOne
    private Usuario operador;
    @OneToOne
    private Accion accionRequerida;

    public Llamada(String descripcionOperador, String detalleAccionRequerida, String duracion, String encuestaEnviada, String observacionAuditor, Cliente cliente, /*Estado estadoActual,*/ List<CambioEstado> cambioEstado) {
        this.descripcionOperador = descripcionOperador;
        this.detalleAccionRequerida = detalleAccionRequerida;
        this.duracion = duracion;
        this.encuestaEnviada = encuestaEnviada;
        this.observacionAuditor = observacionAuditor;
        this.cliente = cliente;
        //this.estadoActual = estadoActual;
        this.cambioEstado = cambioEstado;
    }

    public void /*CambioEstado*/ tomadaPorOperador(State nuevoEstado) {
        //return new CambioEstado(LocalDateTime.now(), nuevoEstado);
    }

    public int calcularDuracion(LocalDateTime fechaYHoraInicial, LocalDateTime fechaYHoraActual) {
        Duration duration = Duration.between(fechaYHoraInicial, fechaYHoraActual);
        long segundos = duration.toSeconds();
        return (int) segundos;
    }

    public boolean esDePeriodo() {
        return true;
    }

    public String getNombreClienteDeLLamada() {
        return this.cliente.getNombreCompleto(); // 9.
    }

    public void finalizarLlamada(LocalDateTime fechaYHora) {
        State estado = new Finalizada();
        //CambioEstado cambioEstado = new CambioEstado(fechaYHora, estado);
        int segundos = this.calcularDuracion(fechaYHora, fechaYHora);
    }

    public CambioEstado crearCambioEstado() { return new CambioEstado(); }
    public void cambiarEstado(State estado) {
        CambioEstado cambioEstado = new CambioEstado();
        cambioEstado.setEstado(estado);
        this.cambioEstado.add(cambioEstado);
    }

}
