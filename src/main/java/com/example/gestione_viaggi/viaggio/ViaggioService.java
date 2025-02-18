package com.example.gestione_viaggi.viaggio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ViaggioService {
    @Autowired
    private ViaggioRepository viaggioRepository;

    public List<Viaggio> findall() {
        return viaggioRepository.findAll();
    }

    public Optional<Viaggio> findById(long id) {
        return viaggioRepository.findById(id);
    }

    public Viaggio save(Viaggio viaggio) {
        return viaggioRepository.save(viaggio);
    }

    public void deleteById(Long id) {
        viaggioRepository.deleteById(id);
    }

    public Viaggio updateStato(Long id, String stato) {
        Viaggio viaggio = viaggioRepository.findById(id).orElseThrow(() -> new RuntimeException
                ("Viaggio non trovato"));
        viaggio.setStato(Viaggio.StatoViaggio.valueOf(stato));
        return viaggioRepository.save(viaggio);
    }

}
