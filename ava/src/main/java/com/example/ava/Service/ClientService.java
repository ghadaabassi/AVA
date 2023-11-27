package com.example.ava.Service;

import com.example.ava.Model.Client;
import com.example.ava.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Optional<Client> getClientByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public Client saveClient(Client client) {
        return clientRepository.save(client);
    }

    public Optional<Client> updateClient(String email, Client updatedClient) {
        return getClientByEmail(email).map(existingClient -> {
            existingClient.setFirstName(updatedClient.getFirstName());
            existingClient.setLastName(updatedClient.getLastName());
            existingClient.setPhoneNumber(updatedClient.getPhoneNumber());
            existingClient.setSecteur(updatedClient.getSecteur());
            existingClient.setResidenceSecteur(updatedClient.getResidenceSecteur());
            existingClient.setAgenceSecteur(updatedClient.getAgenceSecteur());
            return saveClient(existingClient);
        });
    }

    public void deleteClientByEmail(String email) {
        getClientByEmail(email).ifPresent(clientRepository::delete);
    }
}
