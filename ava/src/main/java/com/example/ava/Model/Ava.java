package com.example.ava.Model;

import jakarta.persistence.*;
import java.util.Date;

import com.example.ava.Model.Enums.Etat;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false)
    private int type = 0; // 0:AVAA 1:AVAE

    @Column(nullable = false)
    private double base;

    @Column(nullable = false)
    private double initial = (base * 5) / 10;

    @Column(nullable = false)
    private double solde;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.Attente;

    @OneToOne
    @JoinColumn(name = "client_id")
    @JsonBackReference
    private Client client;

    @ManyToOne
    @JoinColumn(name = "file_id", referencedColumnName = "id", insertable = false, updatable = false)
    private File file;

    public Ava() {

    }

    public Ava(double base, double initial, double solde, Date date, Client client, File file) {

        this.base = base;
        this.initial = initial;
        this.solde = (base * 5) / 10;
        this.date = date;
        this.client = client;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getInitial() {
        return initial;
    }

    public void setInitial(double initial) {
        this.initial = initial;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Etat getEtat() {
        return etat;
    }

    public void setEtat(Etat etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
