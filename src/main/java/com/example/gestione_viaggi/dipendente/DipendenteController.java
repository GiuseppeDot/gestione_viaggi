package com.example.gestione_viaggi.dipendente;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/dipendente")
@RequiredArgsConstructor
public class DipendenteController {

    private final DipendenteService dipendenteService;

    @GetMapping
    public List<Dipendente> findAll() {
        return dipendenteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dipendente> finfById(@PathVariable Long id) {
        return dipendenteService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Dipendente save(@RequestBody Dipendente dipendente) {
        return dipendenteService.save(dipendente);
    }

    @PostMapping("/{id}/upload")
    public Dipendente uploadProfileImage(@PathVariable Long id, @RequestParam("file") MultipartFile file) throws IOException {
        return dipendenteService.uploadProfileImage(id, file);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        dipendenteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}