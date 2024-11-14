package org.bank.electronicmoney.repository;

import org.bank.electronicmoney.entities.Carte;
import org.bank.electronicmoney.entities.Client;
import org.bank.electronicmoney.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CarteRepository extends JpaRepository<Carte, Long> {
    Carte findByNumeroCarte(String numeroCarte);
    List<Carte> findByClient(Client client);
    List<Carte> findByCompte(Compte compte);
    List<Carte> findByActive(boolean active);
    List<Carte> findByTypeCarteId(Long typeCarteId);
}