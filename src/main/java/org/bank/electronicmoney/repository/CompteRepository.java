package org.bank.electronicmoney.repository;
import org.bank.electronicmoney.entities.Client;
import org.bank.electronicmoney.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompteRepository extends JpaRepository<Compte, Long> {
    Compte findByNumeroCompte(String numeroCompte);
    List<Compte> findByClient(Client client);
    List<Compte> findByClientId(Long clientId);
    List<Compte> findBySoldeGreaterThan(double solde);
}