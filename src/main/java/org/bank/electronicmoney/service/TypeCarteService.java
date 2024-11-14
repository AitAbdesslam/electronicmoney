package org.bank.electronicmoney.service;

import jakarta.transaction.Transactional;
import org.bank.electronicmoney.entities.TypeCarte;
import org.bank.electronicmoney.repository.TypeCarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TypeCarteService {

    @Autowired
    private TypeCarteRepository typeCarteRepository;

    @Transactional
    public TypeCarte creerTypeCarte(TypeCarte typeCarte) {
        return typeCarteRepository.save(typeCarte);
    }

    public TypeCarte getTypeCarteParId(Long id) {
        return typeCarteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Type de carte non trouvé avec l'ID : " + id));
    }

    public TypeCarte getTypeCarteParNom(String nom) {
        return typeCarteRepository.findByNom(nom);
    }

    public List<TypeCarte> getTousLesTypesCarte() {
        return typeCarteRepository.findAll();
    }

    @Transactional
    public TypeCarte mettreAJourTypeCarte(TypeCarte typeCarte) {
        return typeCarteRepository.save(typeCarte);
    }

    @Transactional
    public void supprimerTypeCarte(Long id) {
        typeCarteRepository.deleteById(id);
    }

    public List<TypeCarte> getTypesCarteInternationaux() {
        return typeCarteRepository.findByInternational(true);
    }

    public List<TypeCarte> getTypesCarteParPlafondQuotidien(double plafond) {
        return typeCarteRepository.findByPlafondQuotidienLessThanEqual(plafond);
    }

    public List<TypeCarte> getTypesCarteParPlafondMensuel(double plafond) {
        return typeCarteRepository.findByPlafondMensuelLessThanEqual(plafond);
    }
}