package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Restaurant {
    private int id;
    private int locatieid;
    private int suprafata;
    private String nume;
    private String specific;
    private List<String> lista_avize = new ArrayList<>();

    public Restaurant(int id, int locatieid, int suprafata, String nume, String specific, List<String> lista_avize) {
        this.id = id;
        this.locatieid = locatieid;
        this.suprafata = suprafata;
        this.nume = nume;
        this.specific = specific;
        this.lista_avize = lista_avize;
    }

    public Restaurant() {
        this.id = -1;
        this.locatieid = -1;
        this.suprafata = 0;
        this.nume = "None";
        this.specific = "None";
        this.lista_avize = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLocatieid() {
        return locatieid;
    }

    public void setLocatieid(int locatieid) {
        this.locatieid = locatieid;
    }

    public int getSuprafata() {
        return suprafata;
    }

    public void setSuprafata(int suprafata) {
        this.suprafata = suprafata;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getSpecific() {
        return specific;
    }

    public void setSpecific(String specific) {
        this.specific = specific;
    }

    public List<String> getLista_avize() {
        return lista_avize;
    }

    public void setLista_avize(List<String> lista_avize) {
        this.lista_avize = lista_avize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurant that = (Restaurant) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, locatieid, suprafata, nume, specific, lista_avize);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "id=" + id +
                ", locatieid=" + locatieid +
                ", suprafata=" + suprafata +
                ", nume='" + nume + '\'' +
                ", specific='" + specific + '\'' +
                ", lista_avize=" + lista_avize +
                '}';
    }
}
