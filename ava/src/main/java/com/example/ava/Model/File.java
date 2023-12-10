package com.example.ava.Model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;

@Entity
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fileName;

    @OneToOne(mappedBy = "file", cascade = CascadeType.ALL)
    private Ava ava;

    public Ava getAva() {
        return ava;
    }

    public void setAva(Ava ava) {
        this.ava = ava;
    }

    @Lob
    @Column(length = 1000000000)
    private byte[] data;

    public File() {
    }

    public File(String fileName, byte[] data, Ava ava) {
        this.fileName = fileName;
        this.data = data;
        this.ava = ava;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public byte[] getData() {
        return data;
    }

    public void setData(byte[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", fileName='" + fileName + '\'' +
                ", data length=" + (data != null ? data.length : 0) +
                '}';
    }
}