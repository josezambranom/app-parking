package org.smartparking.simulacion.data.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlazaDTO {
    private String id;
    private String establecimientoId;
    private String numero;
    private boolean estado;
}
