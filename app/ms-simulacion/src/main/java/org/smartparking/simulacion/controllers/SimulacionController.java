package org.smartparking.simulacion.controllers;

import org.smartparking.simulacion.services.interfaces.SimulacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("api/simulacion")
public class SimulacionController {
    private final SimulacionService service;

    public SimulacionController(SimulacionService service) {
        this.service = service;
    }

    @GetMapping("/iniciar/")
    public String iniciarSimulacion() {
        service.iniciarSimulacion();
        return "Simulación en curso...";
    }
}
