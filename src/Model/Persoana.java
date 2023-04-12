package Model;

import java.util.Objects;

public class Persoana {
    protected int id;
    protected String prenume;
    protected String nume_de_familie;
    protected String gen;
    protected int an_nastere;
    protected int luna_nastere;
    protected int zi_nastere;

    public Persoana(int id, String prenume, String nume_de_familie, String gen, int an_nastere, int luna_nastere, int zi_nastere) {
        this.id = id;
        this.prenume = prenume;
        this.nume_de_familie = nume_de_familie;
        this.gen = gen;
        this.an_nastere = an_nastere;
        this.luna_nastere = luna_nastere;
        this.zi_nastere = zi_nastere;
    }

    public Persoana() {
        this(-1, "None", "None", "None", 0, 0, 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getNume_de_familie() {
        return nume_de_familie;
    }

    public void setNume_de_familie(String nume_de_familie) {
        this.nume_de_familie = nume_de_familie;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getAn_nastere() {
        return an_nastere;
    }

    public void setAn_nastere(int an_nastere) {
        this.an_nastere = an_nastere;
    }

    public int getLuna_nastere() {
        return luna_nastere;
    }

    public void setLuna_nastere(int luna_nastere) {
        this.luna_nastere = luna_nastere;
    }

    public int getZi_nastere() {
        return zi_nastere;
    }

    public void setZi_nastere(int zi_nastere) {
        this.zi_nastere = zi_nastere;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persoana persoana = (Persoana) o;
        return id == persoana.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prenume, nume_de_familie, gen, an_nastere, luna_nastere, zi_nastere);
    }

    @Override
    public String toString() {
        return "Persoana{" +
                "id=" + id +
                ", prenume='" + prenume + '\'' +
                ", nume_de_familie='" + nume_de_familie + '\'' +
                ", gen='" + gen + '\'' +
                ", an_nastere=" + an_nastere +
                ", luna_nastere=" + luna_nastere +
                ", zi_nastere=" + zi_nastere +
                '}';
    }
}
