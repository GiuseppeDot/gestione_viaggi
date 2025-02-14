package com.example.gestione_viaggi.prenotazione;


import com.example.gestione_viaggi.dipendente.Dipendente;
import com.example.gestione_viaggi.viaggio.Viaggio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Prenotazione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Viaggio viaggio;

    @ManyToOne
    private Dipendente dipendente;

    @NotNull(message = "La data di richiesta è obbligatoria")
    private LocalDate dataRichiesta;

    private String note;
}
