package org.bank.electronicmoney.repository;

import org.bank.electronicmoney.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Client findByEmail(String email);
    List<Client> findByNom(String nom);
    List<Client> findByNomAndPrenom(String nom, String prenom);
    List<Client> findByBanqueId(Long banqueId);
}