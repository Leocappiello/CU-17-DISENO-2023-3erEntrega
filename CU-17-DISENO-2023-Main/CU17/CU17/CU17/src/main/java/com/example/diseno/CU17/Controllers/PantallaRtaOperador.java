package com.example.diseno.CU17.Controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.diseno.CU17.Entities.CambioEstado;
import com.example.diseno.CU17.Entities.CategoriaLlamada;
import com.example.diseno.CU17.Entities.Cliente;
import com.example.diseno.CU17.Entities.InformacionCliente;
import com.example.diseno.CU17.Entities.Llamada;
import com.example.diseno.CU17.Entities.OpcionLlamada;
import com.example.diseno.CU17.Entities.OpcionValidacion;
import com.example.diseno.CU17.Entities.SubOpcionLlamada;
import com.example.diseno.CU17.Entities.TipoInformacion;
import com.example.diseno.CU17.Entities.Validacion;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PantallaRtaOperador {
    private GestorRtaOperador gestor;

    private OpcionLlamada opcionLlamada;
    private SubOpcionLlamada subOpcion;
    private String nombreCliente;
    private String descripcion;
    private CategoriaLlamada categoria;
    private List<Validacion> validacion;
    private Llamada llamada;
    private Contenedor contenedor;

    private List<ContenedorDos> cotenedorDos;

    public PantallaRtaOperador() {
        this.gestor = new GestorRtaOperador();
        this.gestor.setPantalla(this);
        // FAKE DATA

        OpcionValidacion opcionUno= new OpcionValidacion(true, "123456");
        OpcionValidacion opcionDos= new OpcionValidacion(false, "789978");

        TipoInformacion tipo = new TipoInformacion("DNI");
        List<OpcionValidacion> opciones = new ArrayList<>();
        opciones.add(opcionUno);
        opciones.add(opcionDos);

        Validacion validacion = new Validacion("desc validacion", "DNI", tipo, opciones);

        InformacionCliente info = new InformacionCliente("nro DNI", opcionUno, tipo, validacion);
        List<InformacionCliente> infoLista = new ArrayList<>();
        infoLista.add(info);

        Estado estadoActual = new Estado("Iniciada");
        CambioEstado cambio = new CambioEstado(LocalDateTime.now(), estadoActual);

        Cliente cliente = new Cliente(123456, "Agustin Bartoloni", 56789, infoLista);
        Llamada llamada = new Llamada("desc operador", "detalle acciones", "2min", "NO", "observacion", cliente, estadoActual, cambio);
        //
        List<Validacion> listValidacion = new ArrayList<>();
        listValidacion.add(validacion);


        CategoriaLlamada categoria= new CategoriaLlamada("categoria", "categoria", "Ventas", 0);
        OpcionLlamada opcionLlamada = new OpcionLlamada("opcion", "opcion", "Problema de servicio", 0, listValidacion, categoria);
        SubOpcionLlamada subopcion = new SubOpcionLlamada("Intermitente", 0, opcionLlamada, listValidacion);

        llamada.setSubOpcionLlamada(subopcion);

        //
        ContenedorDos contenedor = new ContenedorDos(llamada);

         //

        List<ContenedorDos> listContenedor = new ArrayList<ContenedorDos>();
        listContenedor.add(contenedor);
        listContenedor.add(contenedor);
        listContenedor.add(contenedor);

        setCotenedorDos(listContenedor);
        
    }

    public Contenedor mostrarDatosYValidacionesRequeridas() {
        return getContenedor();
    }

    public void permitirIngresoRtaOperador() {

    }

    public void tomarIngresoRespuestas() {
        this.gestor.tomarRtaOperador();
    }

    public void solicitarConfirmacion() {
        tomarConfirmacion();
    }

    public void tomarConfirmacion() {
        this.gestor.confirmar();
    }

    public void informarAccionRegistrada() {
        
    }
}

