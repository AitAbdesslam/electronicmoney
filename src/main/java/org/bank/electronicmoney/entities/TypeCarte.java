package org.bank.electronicmoney.entities;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "types_carte")
public class TypeCarte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String nom;

    @Column(nullable = false)
    private double plafondQuotidien;

    @Column(nullable = false)
    private double plafondMensuel;

    @Column(nullable = false)
    private boolean international;
}