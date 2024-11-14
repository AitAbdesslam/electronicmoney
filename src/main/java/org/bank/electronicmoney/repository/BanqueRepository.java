package org.bank.electronicmoney.repository;

import org.bank.electronicmoney.entities.Banque;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface BanqueRepository extends JpaRepository<Banque, Long> {
    Banque findByNom(String nom);
    Banque findByCodeSwift(String codeSwift);
}