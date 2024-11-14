package org.bank.electronicmoney.controller;

import org.bank.electronicmoney.entities.Carte;
import org.bank.electronicmoney.service.CarteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cartes")
public class CarteController {

    private CarteService carteService;

    public CarteController(CarteService carteService) {
        this.carteService = carteService;
    }

    @PostMapping
    public ResponseEntity<Carte> creerCarte(@RequestBody Carte carte) {
        return ResponseEntity.ok(carteService.creerCarte(carte));
    }

    @GetMapping("/{numeroCarte}")
    public ResponseEntity<Carte> getCarte(@PathVariable String numeroCarte) {
        Carte carte = carteService.getCarteParNumero(numeroCarte);
        if (carte != null) {
            return ResponseEntity.ok(carte);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{numeroCarte}/solde")
    public ResponseEntity<Carte> mettreAJourSolde(@PathVariable String numeroCarte, @RequestParam double montant) {
        Carte carte = carteService.getCarteParNumero(numeroCarte);

        if (carte != null) {
            return ResponseEntity.ok(carte);
        }
        return ResponseEntity.notFound().build();
    }
}