package com.example.gestione_viaggi.viaggio;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public enum StatoViaggio {
    IN_PROGRAMMA, COMPLETATO

}
