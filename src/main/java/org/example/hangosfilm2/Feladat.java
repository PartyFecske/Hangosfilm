package org.example.hangosfilm2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "feladat")
public class Feladat {
    @Id
    private int id;
    @Column(name = "filmid")
    private int filmid;
    @Column(name = "szemelyid")
    private int szemelyid;
    @Column(name = "megnevezes")
    private String megnevezes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmid() {
        return filmid;
    }

    public void setFilmid(int filmid) {
        this.filmid = filmid;
    }

    public int getSzemelyid() {
        return szemelyid;
    }

    public void setSzemelyid(int szemelyid) {
        this.szemelyid = szemelyid;
    }

    public String getMegnevezes() {
        return megnevezes;
    }

    public void setMegnevezes(String megnevezes) {
        this.megnevezes = megnevezes;
    }
}
