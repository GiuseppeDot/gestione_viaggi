package com.example.gestione_viaggi.prenotazione;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prenotazioni")
@RequiredArgsConstructor
public class PrenotazioneController {

    private final PrenotazioneService prenotazioneService;

    @GetMapping
    public List<Prenotazione> findAll() {
        return prenotazioneService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Prenotazione> findById(@PathVariable Long id) {
        return prenotazioneService.findall(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Prenotazione save(@RequestBody Prenotazione prenotazione) {
        return prenotazioneService.save(prenotazione);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        prenotazioneService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
