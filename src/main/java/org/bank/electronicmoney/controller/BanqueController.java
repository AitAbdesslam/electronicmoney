package org.bank.electronicmoney.controller;

import org.bank.electronicmoney.entities.Banque;
import org.bank.electronicmoney.service.BanqueService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/banques")
public class BanqueController {

    private BanqueService banqueService;

    public BanqueController(BanqueService banqueService) {
        this.banqueService = banqueService;
    }

    @PostMapping
    public ResponseEntity<Banque> creerBanque(@RequestBody Banque banque) {
        return ResponseEntity.ok(banqueService.creerBanque(banque));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Banque> getBanque(@PathVariable Long id) {
        Banque banque = banqueService.getBanqueParId(id);
        if (banque != null) {
            return ResponseEntity.ok(banque);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Banque>> getToutesLesBanques() {
        return ResponseEntity.ok(banqueService.getToutesLesBanques());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Banque> mettreAJourBanque(@PathVariable Long id, @RequestBody Banque banque) {
        banque.setId(id);
        return ResponseEntity.ok(banqueService.mettreAJourBanque(banque));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerBanque(@PathVariable Long id) {
        banqueService.supprimerBanque(id);
        return ResponseEntity.noContent().build();
    }
}