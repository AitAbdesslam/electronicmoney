package org.bank.electronicmoney.service;

import jakarta.transaction.Transactional;
import org.bank.electronicmoney.entities.Client;
import org.bank.electronicmoney.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Transactional
    public Client creerClient(Client client) {
        return clientRepository.save(client);
    }

    public Client getClientParId(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client non trouvé avec l'ID : " + id));
    }

    public Client getClientParEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public List<Client> getClientParNom(String nom) {
        return clientRepository.findByNom(nom);
    }

    public List<Client> getTousLesClients() {
        return clientRepository.findAll();
    }

    @Transactional
    public Client mettreAJourClient(Client client) {
        return clientRepository.save(client);
    }

    @Transactional
    public void supprimerClient(Long id) {
        clientRepository.deleteById(id);
    }

    public List<Client> getClientsParBanque(Long banqueId) {
        return clientRepository.findByBanqueId(banqueId);
    }
}