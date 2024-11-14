package org.bank.electronicmoney.service;

import jakarta.transaction.Transactional;
import org.bank.electronicmoney.entities.Banque;
import org.bank.electronicmoney.repository.BanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BanqueService {

    @Autowired
    private BanqueRepository banqueRepository;

    @Transactional
    public Banque creerBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    public Banque getBanqueParId(Long id) {
        return banqueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banque non trouvée avec l'ID : " + id));
    }

    public Banque getBanqueParNom(String nom) {
        return banqueRepository.findByNom(nom);
    }

    public Banque getBanqueParCodeSwift(String codeSwift) {
        return banqueRepository.findByCodeSwift(codeSwift);
    }

    public List<Banque> getToutesLesBanques() {
        return banqueRepository.findAll();
    }

    @Transactional
    public Banque mettreAJourBanque(Banque banque) {
        return banqueRepository.save(banque);
    }

    @Transactional
    public void supprimerBanque(Long id) {
        banqueRepository.deleteById(id);
    }
}