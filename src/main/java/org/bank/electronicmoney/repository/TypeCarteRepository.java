package org.bank.electronicmoney.repository;

import org.bank.electronicmoney.entities.TypeCarte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TypeCarteRepository extends JpaRepository<TypeCarte, Long> {
    TypeCarte findByNom(String nom);
    List<TypeCarte> findByInternational(boolean international);
    List<TypeCarte> findByPlafondQuotidienLessThanEqual(double plafond);
    List<TypeCarte> findByPlafondMensuelLessThanEqual(double plafond);
}