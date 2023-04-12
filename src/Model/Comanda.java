package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Comanda {
    private int id;
    private int clientid;
    private int soferid;
    private List<Produs> produse = new ArrayList<>();
    private List<Bucatar> bucatari_participanti = new ArrayList<>();

    public Comanda(int id, int clientid, int soferid, List<Produs> produse, List<Bucatar> bucatari_participanti) {
        this.id = id;
        this.clientid = clientid;
        this.soferid = soferid;
        this.produse = produse;
        this.bucatari_participanti = bucatari_participanti;
    }

    public Comanda() {
        this.id = -1;
        this.clientid = -1;
        this.soferid = -1;
        this.produse = new ArrayList<>();
        this.bucatari_participanti = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public int getSoferid() {
        return soferid;
    }

    public void setSoferid(int soferid) {
        this.soferid = soferid;
    }

    public List<Produs> getProduse() {
        return produse;
    }

    public void setProduse(List<Produs> produse) {
        this.produse = produse;
    }

    public List<Bucatar> getBucatari_participanti() {
        return bucatari_participanti;
    }

    public void setBucatari_participanti(List<Bucatar> bucatari_participanti) {
        this.bucatari_participanti = bucatari_participanti;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comanda comanda = (Comanda) o;
        return id == comanda.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientid, soferid, produse, bucatari_participanti);
    }

    @Override
    public String toString() {
        return "Comanda{" +
                "id=" + id +
                ", clientid=" + clientid +
                ", soferid=" + soferid +
                ", produse=" + produse +
                ", bucatari_participanti=" + bucatari_participanti +
                '}';
    }
}
