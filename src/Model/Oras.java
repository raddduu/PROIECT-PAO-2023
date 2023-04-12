package Model;

import java.util.Objects;

public class Oras {
    private int id;
    private String nume;
    private int nr_locuitori;

    public Oras(int id, String nume, int nr_locuitori) {
        this.id = id;
        this.nume = nume;
        this.nr_locuitori = nr_locuitori;
    }

    public Oras() {
        this(-1, "None", 0);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getNr_locuitori() {
        return nr_locuitori;
    }

    public void setNr_locuitori(int nr_locuitori) {
        this.nr_locuitori = nr_locuitori;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oras oras = (Oras) o;
        return id == oras.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nume, nr_locuitori);
    }

    @Override
    public String toString() {
        return "Oras{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", nr_locuitori=" + nr_locuitori +
                '}';
    }
}
