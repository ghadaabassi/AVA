package com.example.ava.Service;

import com.example.ava.Model.AvaE;
import com.example.ava.Repository.AvaERepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaEService {

    private final AvaERepository avaERepository;

    @Autowired
    public AvaEService(AvaERepository avaERepository) {
        this.avaERepository = avaERepository;
    }

    public List<AvaE> getAllAvaEs() {
        return avaERepository.findAll();
    }

    public Optional<AvaE> getAvaEById(Long id) {
        return avaERepository.findById(id);
    }

    public AvaE saveAvaE(AvaE avaE) {
        return avaERepository.save(avaE);
    }

    public void deleteAvaE(Long id) {
        avaERepository.deleteById(id);
    }

    public List<AvaE> getAvaEsByClientEmail(String clientEmail) {
        return avaERepository.findByClientEmail(clientEmail);
    }
}
