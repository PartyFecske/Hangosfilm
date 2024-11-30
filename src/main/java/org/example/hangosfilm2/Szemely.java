package org.example.hangosfilm2;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "szemely")
public class Szemely {
    @Id
    private int id;
    @Column(name = "nev")
    private String név;
    @Column(name = "nem")
    private String nem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNév() {
        return név;
    }

    public void setNév(String név) {
        this.név = név;
    }

    public String getNem() {
        return nem;
    }

    public void setNem(String nem) {
        this.nem = nem;
    }
}
