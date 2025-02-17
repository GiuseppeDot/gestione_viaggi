package com.example.gestione_viaggi.prenotazione;


import com.example.gestione_viaggi.dipendente.Dipendente;
import jakarta.persistence.Entity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    public Prenotazione save(Prenotazione prenotazione) {
        Dipendente dipendente = prenotazione.getDipendente();
        LocalDate dataRichiesta = prenotazione.getDataRichiesta();

        List<Prenotazione> prenotazioneEsistente = prenotazioneRepository.findByDipendenteAndDataRichiesta(dipendente, dataRichiesta);

        if (!prenotazioneEsistente.isEmpty()) {
            throw new RuntimeException("Il dipendente è gia impegnato in questa data");
        }
        return prenotazioneRepository.save(prenotazione);
    }

    public List<Prenotazione> findAll() {
        return prenotazioneRepository.findAll();
    }

    public Optional<Prenotazione> findall(Long id) {
        return prenotazioneRepository.findById(id);
    }

    public void deleteById(Long id) {
        prenotazioneRepository.deleteById(id);
    }
}
