package org.bank.electronicmoney.controller;

import org.bank.electronicmoney.entities.TypeCarte;
import org.bank.electronicmoney.service.TypeCarteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/types-carte")
public class TypeCarteController {

    private TypeCarteService typeCarteService;

    public TypeCarteController(TypeCarteService typeCarteService) {
        this.typeCarteService = typeCarteService;
    }

    @PostMapping
    public ResponseEntity<TypeCarte> creerTypeCarte(@RequestBody TypeCarte typeCarte) {
        return ResponseEntity.ok(typeCarteService.creerTypeCarte(typeCarte));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TypeCarte> getTypeCarte(@PathVariable Long id) {
        TypeCarte typeCarte = typeCarteService.getTypeCarteParId(id);
        if (typeCarte != null) {
            return ResponseEntity.ok(typeCarte);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<TypeCarte>> getTousLesTypesCarte() {
        return ResponseEntity.ok(typeCarteService.getTousLesTypesCarte());
    }

    @PutMapping("/{id}")
    public ResponseEntity<TypeCarte> mettreAJourTypeCarte(@PathVariable Long id, @RequestBody TypeCarte typeCarte) {
        typeCarte.setId(id);
        return ResponseEntity.ok(typeCarteService.mettreAJourTypeCarte(typeCarte));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerTypeCarte(@PathVariable Long id) {
        typeCarteService.supprimerTypeCarte(id);
        return ResponseEntity.noContent().build();
    }
}