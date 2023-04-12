package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Produs {
    private int id;
    private String denumire;
    private int nralergeni;
    private List<String> alergeni = new ArrayList<>();
    private int nringrediente;
    private List<String> ingrediente = new ArrayList<>();
    private double pret;

    public Produs(int id, String denumire, int nralergeni, List<String> alergeni, int nringrediente, List<String> ingrediente, double pret) {
        this.id = id;
        this.denumire = denumire;
        this.nralergeni = nralergeni;
        this.alergeni = alergeni;
        this.nringrediente = nringrediente;
        this.ingrediente = ingrediente;
        this.pret = pret;
    }

    public Produs () {
        this.id = -1;
        this.denumire = "None";
        this.nralergeni = 0;
        this.alergeni = new ArrayList<>();
        this.nringrediente = 0;
        this.ingrediente = new ArrayList<>();
        this.pret = 0.0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getNralergeni() {
        return nralergeni;
    }

    public void setNralergeni(int nralergeni) {
        this.nralergeni = nralergeni;
    }

    public List<String> getAlergeni() {
        return alergeni;
    }

    public void setAlergeni(List<String> alergeni) {
        this.alergeni = alergeni;
    }

    public int getNringrediente() {
        return nringrediente;
    }

    public void setNringrediente(int nringrediente) {
        this.nringrediente = nringrediente;
    }

    public List<String> getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(List<String> ingrediente) {
        this.ingrediente = ingrediente;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produs produs = (Produs) o;
        return id == produs.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, denumire, nralergeni, alergeni, nringrediente, ingrediente, pret);
    }

    @Override
    public String toString() {
        return "Produs{" +
                "id=" + id +
                ", denumire='" + denumire + '\'' +
                ", nralergeni=" + nralergeni +
                ", alergeni=" + alergeni +
                ", nringrediente=" + nringrediente +
                ", ingrediente=" + ingrediente +
                ", pret=" + pret +
                '}';
    }
}
