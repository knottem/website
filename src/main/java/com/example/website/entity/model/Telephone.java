package com.example.website.entity.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "telefon")
public class Telephone {

    @Id
    @Column(name = "idtelefon")
    private int idtelefon;

    @Column(name = "userid")
    private int userid;

    @Column(name = "mobilnummer")
    private String mobilnummer;

    @Column(name = "hemnummer")
    private String hemnummer;


    public int getIdtelefon() {
        return idtelefon;
    }

    public void setIdtelefon(int idtelefon) {
        this.idtelefon = idtelefon;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getMobilnummer() {
        return mobilnummer;
    }

    public void setMobilnummer(String mobilnummer) {
        this.mobilnummer = mobilnummer;
    }

    public String getHemnummer() {
        return hemnummer;
    }

    public void setHemnummer(String hemnummer) {
        this.hemnummer = hemnummer;
    }
}
