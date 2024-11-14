package org.bank.electronicmoney.service;

import org.bank.electronicmoney.entities.Client;
import org.bank.electronicmoney.entities.Compte;
import org.bank.electronicmoney.repository.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompteService {

    @Autowired
    private CompteRepository compteRepository;

    @Transactional
    public Compte creerCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    public Compte getCompteParId(Long id) {
        return compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Compte non trouvé avec l'ID : " + id));
    }

    public Compte getCompteParNumero(String numeroCompte) {
        return compteRepository.findByNumeroCompte(numeroCompte);
    }

    public List<Compte> getComptesParClient(Client client) {
        return compteRepository.findByClient(client);
    }

    public List<Compte> getTousLesComptes() {
        return compteRepository.findAll();
    }

    @Transactional
    public Compte mettreAJourCompte(Compte compte) {
        return compteRepository.save(compte);
    }

    @Transactional
    public void supprimerCompte(Long id) {
        compteRepository.deleteById(id);
    }

    @Transactional
    public Compte deposer(Long compteId, double montant) {
        Compte compte = getCompteParId(compteId);
        compte.setSolde(compte.getSolde() + montant);
        return compteRepository.save(compte);
    }

    @Transactional
    public Compte retirer(Long compteId, double montant) {
        Compte compte = getCompteParId(compteId);
        if (compte.getSolde() < montant) {
            throw new RuntimeException("Solde insuffisant");
        }
        compte.setSolde(compte.getSolde() - montant);
        return compteRepository.save(compte);
    }

    public List<Compte> getComptesAvecSoldeSuperieurA(double solde) {
        return compteRepository.findBySoldeGreaterThan(solde);
    }
}