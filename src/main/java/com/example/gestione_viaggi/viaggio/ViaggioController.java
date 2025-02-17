package com.example.gestione_viaggi.viaggio;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/viaggi")
@RequiredArgsConstructor
public class ViaggioController {

    private final ViaggioService viaggioService;

    @GetMapping("/{id}")
    public ResponseEntity<Viaggio> findById(@PathVariable Long id) {
        return viaggioService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/{id}/stato")
    public Viaggio updateStato(@PathVariable Long id, @RequestParam Viaggio.StatoViaggio stato) {

        return viaggioService.updateStato(id, String.valueOf(stato));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        viaggioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
