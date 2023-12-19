package com.example.diseno.CU17.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.diseno.CU17.Entities.Cliente;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@Component  @RestController @CrossOrigin("*")
public class RestControllerRtaOperador {
    private PantallaRtaOperador pantalla;

    public RestControllerRtaOperador() {
        PantallaRtaOperador pantalla = new PantallaRtaOperador();
        this.pantalla = pantalla;
    }

    @GetMapping("/data")
    public String getData(@RequestParam(required = false) Optional<Integer> id) {
        List<ContenedorDos> data = pantalla.getCotenedorDos();
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        String json;

        try {
            List<ContenedorDos> response = data;

            if (!id.isPresent()) {
                json = objectMapper.writeValueAsString(response);
                return json;
            }
            
            json = objectMapper.writeValueAsString(response.get(id.get()));
            return json;
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Error");
        }

        return "Error";
    }

    @PostMapping("/")
    public void tomarIngresoDatoValidacion(@RequestBody() ObjetoRecibido parametros){
        // data
        List<Boolean> validaciones = parametros.getCorrecto();

        //Cliente cliente = this.pantalla.getGestor().getLlamada().getCliente();
        for (Boolean validacion : validaciones) {
            //cliente.esValidacion(validacion);
            //cliente.esInformacionCorrecta(validacion.getBoolean(null));
        }
    }


}
