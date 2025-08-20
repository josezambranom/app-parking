package org.smartparking.simulacion.services.interfaces;

import org.smartparking.simulacion.data.dto.PlazaDTO;
import java.util.List;

public interface SimulacionService {
    void iniciarSimulacion();
    List<PlazaDTO> obtenerPlazasLibres();
}
