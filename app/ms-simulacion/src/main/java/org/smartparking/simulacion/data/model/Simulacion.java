package org.smartparking.simulacion.data.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "simulaciones")
public class Simulacion {
    @Id
    private String id;
    private String plazaId;
    private boolean estado;
    private LocalDateTime fechaHora;
}
