package org.smartparking.simulacion.services.impl;

import java.util.Arrays;
import java.util.List;

import org.smartparking.simulacion.data.dto.PlazaDTO;
import org.smartparking.simulacion.services.interfaces.SimulacionService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SimulacionServiceImpl implements SimulacionService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${plazas.service.url}")
    private String plazasServiceUrl;

    @Override
    public List<PlazaDTO> obtenerPlazasLibres() {
        PlazaDTO[] plazas = restTemplate.getForObject(plazasServiceUrl, PlazaDTO[].class);
        return plazas != null ? Arrays.asList(plazas) : List.of();
    }

    @Override
    @Scheduled(fixedRate = 10000) // cada 10 segundos
    public void iniciarSimulacion() {
        List<PlazaDTO> plazas = obtenerPlazasLibres();

        for (PlazaDTO plaza : plazas) {
            boolean nuevoEstado = Math.random() > 0.5;
            plaza.setEstado(nuevoEstado);

            String updateUrl = plazasServiceUrl + "/" + plaza.getId() + "/estado?ocupado=" + nuevoEstado;
            restTemplate.put(updateUrl, null);

            System.out.printf("Plaza %s actualizada a %s%n", plaza.getId(), nuevoEstado);
        }
    }
}