package com.example.ava.Model;

import jakarta.persistence.Entity;

@Entity
public class Agent extends Personne {

    private boolean etranger;

    public Agent() {

    }

    public Agent(String firstName, String lastName, String email, String phoneNumber, boolean etranger) {
        super(firstName, lastName, email, phoneNumber);
        this.etranger = etranger;
    }

    public boolean isEtranger() {
        return etranger;
    }

    public void setEtranger(boolean etranger) {
        this.etranger = etranger;
    }

}
