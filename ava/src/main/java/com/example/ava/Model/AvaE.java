package com.example.ava.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class AvaE extends Ava {

    @OneToMany(mappedBy = "avae", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Beneficiaire> beneficiaires;

    public AvaE() {

    }

    public AvaE(long base, long initial, long solde, Date date, Client client, File file,
            List<Beneficiaire> beneficiaires) {
        super(base, initial, solde, date, client, file);
        this.setType(1);
        this.beneficiaires = beneficiaires;
        // this.setBeneficiaires(beneficiaires);

    }

    @Column(nullable = false)
    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
        for (Beneficiaire beneficiaire : beneficiaires) {
            beneficiaire.setAvaE(this);
            // System.out.println("Setting AvaE for Beneficiaire: " +
            // beneficiaire.getEmail());
        }
    }
}
