package org.example.hangosfilm2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "film")
public class Film {
    @Id
    private int id;
    @Column(name = "cim")
    private String cím;
    @Column(name = "gyartas")
    private int gyártás;
    @Column(name = "hossz")
    private int hossz;
    @Column(name = "bemutato")
    private String bemutató;
    @Column(name = "youtube")
    private int youtube;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCím() {
        return cím;
    }

    public void setCím(String cím) {
        this.cím = cím;
    }

    public int getGyártás() {
        return gyártás;
    }

    public void setGyártás(int gyártás) {
        this.gyártás = gyártás;
    }

    public int getHossz() {
        return hossz;
    }

    public void setHossz(int hossz) {
        this.hossz = hossz;
    }

    public String getBemutató() {
        return bemutató;
    }

    public void setBemutató(String bemutató) {
        this.bemutató = bemutató;
    }

    public int getYoutube() {
        return youtube;
    }

    public void setYoutube(int youtube) {
        this.youtube = youtube;
    }
}
