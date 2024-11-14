package org.bank.electronicmoney.config;

import org.bank.electronicmoney.entities.*;
import org.bank.electronicmoney.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private BanqueService banqueService;

    private ClientService clientService;

    private CompteService compteService;

    private TypeCarteService typeCarteService;

    private CarteService carteService;

    public DataInitializer(BanqueService banqueService, ClientService clientService, CompteService compteService, TypeCarteService typeCarteService, CarteService carteService) {
        this.banqueService = banqueService;
        this.clientService = clientService;
        this.compteService = compteService;
        this.typeCarteService = typeCarteService;
        this.carteService = carteService;
    }


    @Override
    public void run(String... args) throws Exception {
        // Création d'une banque
        Banque banque = new Banque();
        banque.setNom("Ma Banque");
        banque.setCodeSwift("MABAFR1X");
        banqueService.creerBanque(banque);

        // Création d'un client
        Client client = new Client();
        client.setNom("Dupont");
        client.setPrenom("Jean");
        client.setEmail("jean.dupont@email.com");
        client.setTelephone("0123456789");
        client.setDateNaissance(LocalDate.of(1980, 1, 1));
        client.setAdresse("123 Rue de la Banque, 75001 Paris");
        clientService.creerClient(client);

        // Création d'un compte
        Compte compte = new Compte();
        compte.setNumeroCompte("FR7630001007941234567890185");
        compte.setSolde(1000.0);
        compte.setClient(client);
        compteService.creerCompte(compte);

        // Création d'un type de carte
        TypeCarte typeCarte = new TypeCarte();
        typeCarte.setNom("Carte Gold");
        typeCarte.setPlafondQuotidien(1000.0);
        typeCarte.setPlafondMensuel(5000.0);
        typeCarte.setInternational(true);
        typeCarteService.creerTypeCarte(typeCarte);

        // Création d'une carte
        Carte carte = new Carte();
        carte.setNumeroCarte("1234567890123456");
        carte.setDateExpiration(LocalDate.now().plusYears(3));
        carte.setCodePin("1234");
        carte.setActive(true);
        carte.setClient(client);
        carte.setCompte(compte);
        carte.setTypeCarte(typeCarte);
        carteService.creerCarte(carte);

        System.out.println("Données initiales insérées avec succès !");
    }
}