package org.bank.electronicmoney.entities;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "banques")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(unique = true, nullable = false)
    private String codeSwift;

    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Client> clients;
}