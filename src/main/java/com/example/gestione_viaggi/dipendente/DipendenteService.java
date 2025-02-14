package com.example.gestione_viaggi.dipendente;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DipendenteService {

    private final DipendenteRepository dipendenteRepository;


    // Metodo per ottenere tutti i dipendenti dal repository
    public List<Dipendente> findAll() {
        return dipendenteRepository.findAll();
    }

    // Metodo per cercare un dipendente per ID
    public Optional<Dipendente> findById(Long id) {
        return dipendenteRepository.findById(id);
    }

    // Metodo per salvare un nuovo dipendente
    public Dipendente save(Dipendente dipendente) {
        return dipendenteRepository.save(dipendente);
    }

    // Metodo per eliminare un dipendente
    public void deleteById(Long id) {
        dipendenteRepository.deleteById(id);
    }

    // Metodo per caricare l'immagine del profilo
    //Non ho capito bene come funziona, ho dovuto fare un po' di ricerca
    public Dipendente uploadProfileImage(Long id, MultipartFile file) throws IOException {
        Dipendente dipendente = dipendenteRepository.findById(id).orElseThrow(() -> new RuntimeException
                ("Dipendente non trovato"));
        Path path = Paths.get("upload/" + file.getOriginalFilename());
        Files.write(path, file.getBytes());
        dipendente.setProfileImagePath(path.toString());
        return dipendenteRepository.save(dipendente);
    }
}