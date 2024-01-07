package com.example.ava.Model;

import jakarta.persistence.Entity;

@Entity
public class Agent extends Personne {

    private boolean etranger;
    private String password;

    public Agent() {

    }

    public Agent(String firstName, String lastName, String email, String phoneNumber, boolean etranger,
            String password) {
        super(firstName, lastName, email, phoneNumber);
        this.etranger = etranger;
        this.password = password;

    }

    public boolean isEtranger() {
        return etranger;
    }

    public void setEtranger(boolean etranger) {
        this.etranger = etranger;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
