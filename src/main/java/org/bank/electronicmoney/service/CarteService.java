package org.bank.electronicmoney.service;

import jakarta.transaction.Transactional;
import org.bank.electronicmoney.entities.Carte;
import org.bank.electronicmoney.entities.Client;
import org.bank.electronicmoney.entities.Compte;
import org.bank.electronicmoney.repository.CarteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CarteService {

    @Autowired
    private CarteRepository carteRepository;

    @Transactional
    public Carte creerCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    public Carte getCarteParId(Long id) {
        return carteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carte non trouvée avec l'ID : " + id));
    }

    public Carte getCarteParNumero(String numeroCarte) {
        return carteRepository.findByNumeroCarte(numeroCarte);
    }

    public List<Carte> getCartesParClient(Client client) {
        return carteRepository.findByClient(client);
    }

    public List<Carte> getCartesParCompte(Compte compte) {
        return carteRepository.findByCompte(compte);
    }

    public List<Carte> getToutesLesCartes() {
        return carteRepository.findAll();
    }

    @Transactional
    public Carte mettreAJourCarte(Carte carte) {
        return carteRepository.save(carte);
    }

    @Transactional
    public void supprimerCarte(Long id) {
        carteRepository.deleteById(id);
    }

    @Transactional
    public Carte activerCarte(Long id) {
        Carte carte = getCarteParId(id);
        carte.setActive(true);
        return carteRepository.save(carte);
    }

    @Transactional
    public Carte desactiverCarte(Long id) {
        Carte carte = getCarteParId(id);
        carte.setActive(false);
        return carteRepository.save(carte);
    }

    public List<Carte> getCartesActives() {
        return carteRepository.findByActive(true);
    }

    public List<Carte> getCartesParTypeCarte(Long typeCarteId) {
        return carteRepository.findByTypeCarteId(typeCarteId);
    }
}