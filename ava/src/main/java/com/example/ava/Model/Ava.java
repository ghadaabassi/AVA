package com.example.ava.Model;

import jakarta.persistence.*;
import java.util.Date;

import com.example.ava.Model.Enums.Etat;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Ava {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // @Column(nullable = false)
    private int type = 0; // 0:AVAA 1:AVAE

    @Column(nullable = false)
    private long base;

    @Column(nullable = false)
    private Long initial;

    @Column(nullable = false)
    private Long solde;

    @Temporal(TemporalType.DATE)
    private Date date;

    @Enumerated(EnumType.STRING)
    private Etat etat = Etat.Attente;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "client_id", unique = true)
    private Client client;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "file_id")
    private File file; 

    public Ava() {

    }

    public Ava(long base, long initial, long solde, Date date, Client client, File file) {

        this.base = base;
        this.initial = initial;
        this.solde = solde;
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

    public long getBase() {
        return base;
    }

    public void setBase(long base) {
        this.base = base;
    }

    public long getInitial() {
        return initial;
    }

    public void setInitial(long initial) {
        this.initial = initial;
    }

    public long getSolde() {
        return solde;
    }

    public void setSolde(long solde) {
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
