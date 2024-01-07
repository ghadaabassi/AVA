package com.example.ava.Service;

import com.example.ava.Model.Ava;
import com.example.ava.Model.Enums.Etat;
import com.example.ava.Repository.AvaRepository;
import com.example.ava.Repository.ClientRepository;
import com.example.ava.Repository.FileRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaService {

    private final AvaRepository avaRepository;
    private final ClientRepository clientRepository;
  
    @Autowired
    public AvaService(AvaRepository avaRepository, ClientRepository clientRepository) {
        this.avaRepository = avaRepository;
        this.clientRepository = clientRepository;
       
    }

    public List<Ava> getAllAvas() {
        return avaRepository.findAll();
    }

    public Optional<Ava> getAvaById(Long id) {
        return avaRepository.findById(id);
    }

    public Ava saveAva(Ava ava) {
        return avaRepository.save(ava);
    }

    public boolean deleteAva(Long id) {
        try {
            avaRepository.deleteById(id);
            return true;
        } catch (Exception e) {

            return false;
        }
    }

    public List<Ava> getAvasByClientId(Long clientId) {
        return avaRepository.findByClientId(clientId);
    }

     public List<Ava> getAllAvasNotInAttente() {
        // Implement logic to retrieve Avas where Etat is not equal to Etat.Attente
        return avaRepository.findByEtatNot(Etat.Attente);
    }

    public List<Ava> getAllAvasInAttente() {
        // Implement logic to retrieve Avas where Etat is equal to Etat.Attente
        return avaRepository.findByEtat(Etat.Attente);
    }
}
