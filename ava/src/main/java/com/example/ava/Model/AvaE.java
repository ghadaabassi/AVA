package com.example.ava.Model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
public class AvaE extends Ava {

    @OneToMany(mappedBy = "avae", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Beneficiaire> beneficiaires;

    public AvaE() {

    }

    public AvaE(long base, long initial, long solde, Date date, Client client, File fileData,
            List<Beneficiaire> beneficiaires) {
        super(base, initial, solde, date, client, fileData);
        this.setType(1);
        this.beneficiaires = beneficiaires;
    }

    @Column(nullable = false)
    public List<Beneficiaire> getBeneficiaires() {
        return beneficiaires;
    }

    public void setBeneficiaires(List<Beneficiaire> beneficiaires) {
        this.beneficiaires = beneficiaires;
    }
}
