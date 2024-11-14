package org.bank.electronicmoney.repository;

import org.bank.electronicmoney.entities.Compte;
import org.bank.electronicmoney.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByCompte(Compte compte);
    List<Transaction> findByCompteAndDateTransactionBetween(Compte compte, LocalDateTime debut, LocalDateTime fin);
    List<Transaction> findByTypeTransaction(String typeTransaction);
    List<Transaction> findByStatut(String statut);

    @Query("SELECT t FROM Transaction t WHERE t.compte = :compte ORDER BY t.dateTransaction DESC LIMIT :limit")
    List<Transaction> findLastNTransactions(@Param("compte") Compte compte, @Param("limit") int limit);

    @Query("SELECT SUM(t.montant) FROM Transaction t WHERE t.compte = :compte AND t.dateTransaction BETWEEN :debut AND :fin")
    Double calculateBalanceForPeriod(@Param("compte") Compte compte, @Param("debut") LocalDateTime debut, @Param("fin") LocalDateTime fin);
}