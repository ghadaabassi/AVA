package com.example.ava.Service;

import com.example.ava.Model.Beneficiaire;
import com.example.ava.Repository.BeneficiaireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiaireService {

    private final BeneficiaireRepository beneficiaireRepository;

    @Autowired
    public BeneficiaireService(BeneficiaireRepository beneficiaireRepository) {
        this.beneficiaireRepository = beneficiaireRepository;
    }

    public List<Beneficiaire> getAllBeneficiaires() {
        return beneficiaireRepository.findAll();
    }

    public Optional<Beneficiaire> getBeneficiaireByEmail(String email) {
        return beneficiaireRepository.findByEmail(email);
    }

    public Beneficiaire saveBeneficiaire(Beneficiaire beneficiaire) {
        return beneficiaireRepository.save(beneficiaire);
    }

    public Optional<Beneficiaire> updateBeneficiaire(String email, Beneficiaire updatedBeneficiaire) {
        return getBeneficiaireByEmail(email).map(existingBeneficiaire -> {
            existingBeneficiaire.setFirstName(updatedBeneficiaire.getFirstName());
            existingBeneficiaire.setLastName(updatedBeneficiaire.getLastName());
            existingBeneficiaire.setPhoneNumber(updatedBeneficiaire.getPhoneNumber());
            existingBeneficiaire.setFonction(updatedBeneficiaire.getFonction());
            existingBeneficiaire.setDateInscription(updatedBeneficiaire.getDateInscription());
            return saveBeneficiaire(existingBeneficiaire);
        });
    }

    public void deleteBeneficiaireByEmail(String email) {
        getBeneficiaireByEmail(email).ifPresent(beneficiaireRepository::delete);
    }
}
