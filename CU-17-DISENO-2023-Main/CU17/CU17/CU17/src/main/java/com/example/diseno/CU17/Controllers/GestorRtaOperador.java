package com.example.diseno.CU17.Controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.diseno.CU17.Entities.CambioEstado;
import com.example.diseno.CU17.Entities.CategoriaLlamada;
import com.example.diseno.CU17.Entities.Cliente;
import com.example.diseno.CU17.Entities.Llamada;
import com.example.diseno.CU17.Entities.OpcionLlamada;
import com.example.diseno.CU17.Entities.SubOpcionLlamada;
import com.example.diseno.CU17.Entities.Validacion;

import com.example.diseno.CU17.Entities.state.EnCurso;
import com.example.diseno.CU17.Entities.state.State;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class GestorRtaOperador {
    private PantallaRtaOperador pantalla;
    
    private String nombreCliente;
    private State enCurso;
    private CambioEstado cambioEnCurso;
    
    private List<Validacion> validaciones;

    private SubOpcionLlamada subopcion;
    private OpcionLlamada opcionLlamada;
    private CategoriaLlamada categoriaLlamada;
    private Llamada llamada;

    public Contenedor nuevaRespuestaOperador(Llamada llamada) {
        // El operador recibe una llamada
        this.llamada = llamada;
        return this.recibirLlamada(llamada);
    }

    public Contenedor recibirLlamada(Llamada llamada) {
        this.enCurso = this.buscarEstadoEnCurso(llamada); // 3.
        llamada.tomadaPorOperador(this.enCurso); // 5. y 6.

        String descripcion = this.obtenerDatosLlamada(llamada); // 7.
        List<String> validaciones = this.buscarValidaciones(); //13.

        Contenedor data = new Contenedor(descripcion, llamada, categoriaLlamada, validaciones);
        return data;
    }

    public State buscarEstadoEnCurso(Llamada llamada) {
        State estadoActual = llamada.getEstadoActual();

        if (!estadoActual.esEnCurso()) { //4.
//            State nuevoEstado = new EnCurso("En curso");
//            return nuevoEstado;
        }
        return null;
    }

    public String obtenerDatosLlamada(Llamada llamada) {
        this.nombreCliente = llamada.getNombreClienteDeLLamada(); // 8.

        this.opcionLlamada = llamada.getOpcionSeleccionada();
        this.categoriaLlamada = opcionLlamada.getCategoriaLlamada();
        this.subopcion = llamada.getSubOpcionLlamada();

        String opcionSubopcion = categoriaLlamada.getDescripcionCompletaCategoriaYOpcion(subopcion, opcionLlamada); // 10.
        String descripcionCompleta = categoriaLlamada.getNombre() + " - " + opcionSubopcion;

        return descripcionCompleta;
    }

    public List<String> buscarValidaciones() {
        return this.categoriaLlamada.buscarValidaciones(this.opcionLlamada, this.subopcion);
    }

    public void tomarDatosValidacion() {
        //this.validarInformacionCliente();
    }

    public void validarInformacionCliente(Cliente cliente) {
        /* boolean result = cliente.esInformacionCorrecta();
        if (result) {
            this.pantalla.permitirIngresoRtaOperador();
        } */
    }

    public void tomarRtaOperador() {
        this.pantalla.solicitarConfirmacion();
    }

    public void confirmar() {
        // CU 28 - Ejecuta con exito
        
        //
        this.pantalla.informarAccionRegistrada();
        this.finalizarLlamada();
    }

    public void finalizarLlamada() {
        //this.obtenerFechaYHoraActual();
    }

    public void obtenerFechaYHoraActual(Llamada llamada) {
        LocalDateTime fechaYHora = LocalDateTime.now();
        //boolean esFinalizada = this.buscarEstadoFinalizada();
        //llamada.finalizarLlamada();
        this.finCU();
    }

    /*
    public boolean buscarEstadoFinalizada() {
        for (Estado estado : estados) {
            if(estado.esFinalizada()) {
                return true;
            }
            return false;
        }
    } */

    public void finCU() { }
    //
    public void nuevaLlamada() {}
    public void getMsjInicial() {}
    public void tomarDniCliente() {
        identificarCliente(123);
    }
    public void identificarCliente(int dni) {
        this.llamada.getCliente().esCliente(dni);
        this.tomarFechaYHoraActual();
    }

    public void tomarFechaYHoraActual() {
        Date date = new Date();
        this.buscarEstadoInicial();
    }

    public void buscarEstadoInicial() {
        //
        Boolean esIniciada = this.llamada.getEstadoActual().esIniciada();
        //
        crearLlamada();
    }

    public void crearLlamada() {
        Llamada nueva = new Llamada();
        CambioEstado iniciada = nueva.crearCambioEstado();
        this.getMsjCategoria();
    }

    // endpoint ?
    public void getMsjCategoria() {

    }

    public String buscarCategoria() {
        // buscar categorias
        List<CategoriaLlamada> categorias = new ArrayList<>();

        for(CategoriaLlamada categoria: categorias) {
            if (categoria.esNroCat(categoria.getNroOrden())) {
                return categoria.getAudioMensajeOpciones();
            }
        }

        return null;
    }

}