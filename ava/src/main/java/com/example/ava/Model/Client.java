package com.example.ava.Model;

import com.example.ava.Model.Enums.Secteur;

import jakarta.persistence.*;

@Entity
public class Client extends Personne {

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Secteur secteur;

    @Column(nullable = false)
    private String residenceSecteur;

    @Column(nullable = false)
    private String agenceSecteur;

    public Client() {

    }

    public Client(String firstName, String lastName, String email, String phoneNumber, Secteur secteur,
            String residenceSecteur, String agenceSecteur) {
        super(firstName, lastName, email, phoneNumber);
        this.secteur = secteur;
        this.residenceSecteur = residenceSecteur;
        this.agenceSecteur = agenceSecteur;
    }

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public String getResidenceSecteur() {
        return residenceSecteur;
    }

    public void setResidenceSecteur(String residenceSecteur) {
        this.residenceSecteur = residenceSecteur;
    }

    public String getAgenceSecteur() {
        return agenceSecteur;
    }

    public void setAgenceSecteur(String agenceSecteur) {
        this.agenceSecteur = agenceSecteur;
    }
}
