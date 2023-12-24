package com.example.ava.Service;

import com.example.ava.Model.Ava;
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
    private final FileRepository fileRepository;

    @Autowired
    public AvaService(AvaRepository avaRepository, ClientRepository clientRepository, FileRepository fileRepository) {
        this.avaRepository = avaRepository;
        this.clientRepository = clientRepository;
        this.fileRepository = fileRepository;
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
}
