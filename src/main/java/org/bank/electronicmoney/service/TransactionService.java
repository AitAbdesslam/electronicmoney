package org.bank.electronicmoney.service;


import org.bank.electronicmoney.entities.Compte;
import org.bank.electronicmoney.entities.Transaction;
import org.bank.electronicmoney.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CompteService compteService;

    @Transactional
    public Transaction creerTransaction(Transaction transaction) {
        Compte compte = transaction.getCompte();
        if ("DEBIT".equals(transaction.getTypeTransaction())) {
            compteService.retirer(compte.getId(), transaction.getMontant());
        } else if ("CREDIT".equals(transaction.getTypeTransaction())) {
            compteService.deposer(compte.getId(), transaction.getMontant());
        }
        return transactionRepository.save(transaction);
    }

    public Transaction getTransactionParId(Long id) {
        return transactionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaction non trouvée avec l'ID : " + id));
    }

    public List<Transaction> getTransactionsParCompte(Compte compte) {
        return transactionRepository.findByCompte(compte);
    }

    public List<Transaction> getTransactionsParComptePourPeriode(Compte compte, LocalDateTime debut, LocalDateTime fin) {
        return transactionRepository.findByCompteAndDateTransactionBetween(compte, debut, fin);
    }

    public List<Transaction> getToutesLesTransactions() {
        return transactionRepository.findAll();
    }

    @Transactional
    public Transaction mettreAJourTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsParType(String typeTransaction) {
        return transactionRepository.findByTypeTransaction(typeTransaction);
    }

    public List<Transaction> getTransactionsParStatut(String statut) {
        return transactionRepository.findByStatut(statut);
    }

    public List<Transaction> getDernieresTransactions(Compte compte, int nombre) {
        return transactionRepository.findLastNTransactions(compte, nombre);
    }

    public Double calculerSoldePourPeriode(Compte compte, LocalDateTime debut, LocalDateTime fin) {
        return transactionRepository.calculateBalanceForPeriod(compte, debut, fin);
    }
}