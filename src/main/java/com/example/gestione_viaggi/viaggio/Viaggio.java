package com.example.gestione_viaggi.viaggio;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viaggio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Il campo destinazione è obbligatorio")
    private String destinazione;

    @NotNull(message = "La data è obbligatoria")
    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private StatoViaggio stato;

    public enum StatoViaggio {
        IN_PROGRAMMA, COMPLETATO

    }

}
