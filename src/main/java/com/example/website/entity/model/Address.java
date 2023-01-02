package com.example.website.entity.model;

import jakarta.persistence.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Timestamp;

@Entity
@Table(name = "address")
public class Address {

    private final static Logger logger = LogManager.getLogger(Address.class);

    @Id
    @Column(name = "adressid")
    private int adressid;

    @Column(name = "userid")
    private int userid;

    @Column(name = "gatuadress")
    private String gatuadress;

    @Column(name = "gatunummer")
    private String gatunummer;

    @Column(name = "postnr")
    private String postnr;

    @Column(name = "postadress")
    private String postadress;

    @Column(name = "stad")
    private String stad;

    @Column(name = "land")
    private String land;

    @Column(name = "create_time")
    private Timestamp create_time;

    @Column(name = "last_update")
    private Timestamp last_update;

    public int getAdressid() {
        return adressid;
    }

    public void setAdressid(int adressid) {
        this.adressid = adressid;
    }

    public String getGatuadress() {
        return gatuadress;
    }

    public void setGatuadress(String gatuadress) {
        this.gatuadress = gatuadress;
    }

    public String getGatunummer() {
        return gatunummer;
    }

    public void setGatunummer(String gatunummer) {
        this.gatunummer = gatunummer;
    }

    public String getPostnr() {
        return postnr;
    }

    public void setPostnr(String postnr) {
        this.postnr = postnr;
    }

    public String getPostadress() {
        return postadress;
    }

    public void setPostadress(String postadress) {
        this.postadress = postadress;
    }

    public String getStad() {
        return stad;
    }

    public void setStad(String stad) {
        this.stad = stad;
    }

    public String getLand() {
        return land;
    }

    public int getUserid() {
        return userid;
    }

    public void setCreate_time(Timestamp create_time) {
        this.create_time = create_time;
    }

    public void setLast_update(Timestamp last_update) {
        this.last_update = last_update;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setLand(String land) {
        this.land = land;
    }

    public Timestamp getCreate_time() {
        return create_time;
    }


    public Timestamp getLast_update() {
        return last_update;
    }


    public void printAdress(){
        String adress = "Adress{" +
                "adressid=" + adressid +
                ", gatuadress='" + gatuadress + '\'' +
                ", gatunummer='" + gatunummer + '\'' +
                ", postnr='" + postnr + '\'' +
                ", postadress='" + postadress + '\'' +
                ", stad='" + stad + '\'' +
                ", land='" + land + '\'' +
                ", create_time=" + create_time +
                ", last_update=" + last_update +
                '}';
        logger.info(adress);
        System.out.println(adress);
    }


}
