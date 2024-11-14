package org.bank.electronicmoney.controller;

import org.bank.electronicmoney.entities.Compte;
import org.bank.electronicmoney.service.CompteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {

    private CompteService compteService;

    public CompteController(CompteService compteService) {
        this.compteService = compteService;
    }

    @PostMapping
    public ResponseEntity<Compte> creerCompte(@RequestBody Compte compte) {
        return ResponseEntity.ok(compteService.creerCompte(compte));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compte> getCompte(@PathVariable Long id) {
        Compte compte = compteService.getCompteParId(id);
        if (compte != null) {
            return ResponseEntity.ok(compte);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Compte>> getTousLesComptes() {
        return ResponseEntity.ok(compteService.getTousLesComptes());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compte> mettreAJourCompte(@PathVariable Long id, @RequestBody Compte compte) {
        compte.setId(id);
        return ResponseEntity.ok(compteService.mettreAJourCompte(compte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCompte(@PathVariable Long id) {
        compteService.supprimerCompte(id);
        return ResponseEntity.noContent().build();
    }
}