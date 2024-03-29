package com.example.ava.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Beneficiaire extends Personne {

    @ManyToOne
    @JoinColumn(name = "avae_id")
    @JsonBackReference
    private AvaE avae;

    private String fonction;
    private Date dateInscription;

    public Beneficiaire() {

    }

    public Beneficiaire(String firstName, String lastName, String email, String phoneNumber,
            String fonction, String chaine, Date dateInscription, AvaE avae) {
        super(firstName, lastName, email, phoneNumber);
        this.fonction = fonction;
        this.dateInscription = dateInscription;
        this.avae = avae;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Date getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(Date dateInscription) {
        this.dateInscription = dateInscription;
    }

    public AvaE getAvaE() {
        return avae;
    }

    public void setAvaE(AvaE avae) {
        this.avae = avae;
    }
}
